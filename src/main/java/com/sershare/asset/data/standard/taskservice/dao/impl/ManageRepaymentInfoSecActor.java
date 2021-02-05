package com.sershare.asset.data.standard.taskservice.dao.impl;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.config.redis.RedissonLockerUtil;
import com.sershare.asset.data.standard.entity.LoanContractInfo;
import com.sershare.asset.data.standard.entity.RepaymentInfo;
import com.sershare.asset.data.standard.entity.RepaymentSchedule;
import com.sershare.asset.data.standard.explain.File07Head;
import com.sershare.asset.data.standard.service.task.AssetCheckService;
import com.sershare.asset.data.standard.service.task.LoanContractInfoService;
import com.sershare.asset.data.standard.service.task.RepaymentInfoService;
import com.sershare.asset.data.standard.service.task.RepaymentScheduleService;
import com.sershare.asset.data.standard.taskservice.dao.EntityManager;
import com.sershare.asset.data.standard.utils.DateUtils;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/1  15:35
 */
public class ManageRepaymentInfoSecActor implements EntityManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RepaymentInfoService repaymentInfoService;

    @Autowired
    private RepaymentScheduleService repaymentScheduleService;

    @Autowired
    LoanContractInfoService loanContractInfoService;

    @Autowired
    AssetCheckService assetCheckService;


    @Override
    public void insert(JsonObject jsonObject) {
        logger.info("开始执行RepaymentInfo数据插入");
        int result = 0;
        String entityObject = jsonObject.get("entityObject").getAsString();
        RepaymentInfo repaymentInfo = GsonUtils.fromString(entityObject, RepaymentInfo.class);
        do {
            if (repaymentInfo.getPeriod() == 0) {
                logger.info("开始处理0期数据：{}",repaymentInfo);
                boolean success = this.zeroPeriodInsert(repaymentInfo);
                if (!success) {
                    logger.error("0期实还信息插入或者更新出错");
                } else {
                    logger.info("0期实还信息插入或者更新成功");
                }
                break;
            }
            // 处理抵充数据
            BigDecimal totalRelMoney = repaymentInfo.getRelPrincipal().add(repaymentInfo.getRelInterest()).add(repaymentInfo.getRelFee());

            if (!"10041".equals(repaymentInfo.getAgencyId())) {
                // 检查是否存在可抵充的数据，存在着删除
                RepaymentInfo reversalRep = repaymentInfoService.selectUnionByRelDateAndPeriod(repaymentInfo.getProjectId(), repaymentInfo.getAssetId(), null,repaymentInfo.getPeriod());
                if (Objects.nonNull(reversalRep)
                        && (reversalRep.getRelPrincipal().add(repaymentInfo.getRelPrincipal()).equals(BigDecimal.ZERO.setScale(2))
                        && (reversalRep.getRelFee().add(repaymentInfo.getRelFee()).equals(BigDecimal.ZERO.setScale(2))
                        && (reversalRep.getRelInterest().add(repaymentInfo.getRelInterest()).equals(BigDecimal.ZERO.setScale(2)))))) {
                    repaymentInfoService.deleteByPrimaryKey(reversalRep.getId());
                    break;
                }
            }
            //如果不在正常状态下，也应该启动修正任务。数据可能是补充实还信息
            LoanContractInfo loanContractInfo = loanContractInfoService.selectByUnionKey(repaymentInfo.getProjectId(), repaymentInfo.getAssetId());
            if(repaymentInfo.getRealInterestRate() == null || repaymentInfo.getRealInterestRate().compareTo(BigDecimal.ZERO) <= 0){
                repaymentInfo.setRealInterestRate(new BigDecimal(loanContractInfo.getLoanInterestRate()));
            }
            //根据应还日查询出当期的还款计划
            RepaymentSchedule repaymentScheduleOnPeriod = repaymentScheduleService.selectByUnionKey(repaymentInfo.getProjectId(), repaymentInfo.getAssetId(), repaymentInfo.getRepayDate());
            if (Objects.isNull(repaymentScheduleOnPeriod)) {
                //根据期次查询出当期的还款计划
                repaymentScheduleOnPeriod = repaymentScheduleService.selectListByUnionKeyAndPeriod(repaymentInfo.getProjectId(), repaymentInfo.getAssetId(), repaymentInfo.getPeriod());
            }
//            if (Objects.isNull(repaymentScheduleOnPeriod)) {
//                ApiTaskBean moveRepaymentSchBean = apiTaskStartService.getRepaymentSchTask(InsertRepaymentScheduleMoveActuator.class.getSimpleName(),repaymentInfo.getAssetId());
//                if(Objects.isNull(moveRepaymentSchBean) || TASK_NOTDONE.name().equals(moveRepaymentSchBean.getStatus())){
//                    //如果查不到对应的还款计划，说明数据有问题
//                    apiTaskBean.setStatus(TASK_NOTDONE.name());
//                    apiTaskBean.setErrorMsg("还款计划未执行!");
//                }else{
//                    //如果查不到对应的还款计划，说明数据有问题
//                    apiTaskBean.setStatus(TASK_FAIL.name());
//                    apiTaskBean.setErrorMsg(repaymentInfo.getPeriod() + "期还款计划不存在");
//                }
//                break;
//            }
            // 设置当期的应还本息费,应还日
            repaymentInfo.setRepayPrincipal(repaymentScheduleOnPeriod.getRepayPrincipal());
            repaymentInfo.setRepayDate(repaymentScheduleOnPeriod.getRepayDate());
            if (repaymentInfo.getRelPrincipal().compareTo(BigDecimal.ZERO) > 0) {
                repaymentInfo.setRepayInterest(repaymentInfo.getRepayInterest());
                repaymentInfo.setRepayFee(repaymentInfo.getRepayFee());
                repaymentInfo.setRepayPenalty(repaymentInfo.getRepayPenalty());
            } else {
                repaymentInfo.setRepayFee(repaymentScheduleOnPeriod.getRepayFee());
                repaymentInfo.setRepayInterest(repaymentScheduleOnPeriod.getRepayInterest());
                repaymentInfo.setRepayPenalty(repaymentInfo.getRepayPenalty());
            }
            //查询当天当期是否已经存在过实还信息
            RepaymentInfo relRepaymentInfo = repaymentInfoService.selectUnionByRelDateAndPeriod(repaymentInfo.getProjectId(), repaymentInfo.getAssetId(), repaymentInfo.getRelPayDate(), repaymentInfo.getPeriod());
            if (Objects.isNull(relRepaymentInfo)) {
                //有可能是部分还款的情况，应该先排除部分还款。
                List<RepaymentInfo> repaymentInfoParts = repaymentInfoService.selectPartRepayment(repaymentInfo.getProjectId(), repaymentInfo.getAssetId(), repaymentInfo.getPeriod(), repaymentInfo.getRepayDate());
                if (Objects.isNull(repaymentInfoParts) || repaymentInfoParts.isEmpty()) {
                    //因为当日当期没有记录，当期也没有记录，所以要么是当期还款，要么是第一次部分还款
                    // 当期没有其他还款信息，无论是否为部分还款都先插入
                    result = repaymentInfoService.insert(repaymentInfo);
                } else {
                    // 如果是易鑫冲销的情况，易鑫不存在部分还款，也就不会有部分还款的冲销
                    if (totalRelMoney.compareTo(BigDecimal.ZERO) < 0) {
                        if (repaymentInfoParts.size() > 1) {
                            // 数据有问题，冲销情况下每一期的还款信息都只有一条. 等于0的情况if已经排除
                            logger.error(repaymentInfo.getPeriod() + "期有" + repaymentInfoParts.size() + "条。不满足冲销条件");
                            break;
                        }

                        if (repaymentInfoParts.get(0).getTimestamp().compareTo(repaymentInfo.getTimestamp()) > 0) {
                            logger.error("信息已过期");
                            break;
                        }

                        repaymentInfo.setRelPayDate(repaymentInfoParts.get(0).getRepayDate());
                        result = repaymentInfoService.updateByPrimaryKeySelective(repaymentInfo);
                        if (result <= 0) {
                            logger.error("实还信息插入或者更新出错");
                        } else {
                            logger.info("执行成功");
                        }
                        break;
                    }

                    // 判断是否是同样数据，不同的实还日期
                    List<RepaymentInfo> sortRepaymentInfoParts= repaymentInfoParts.stream()
                            .sorted(Comparator.comparing(RepaymentInfo::getRelPayDate)).collect(Collectors.toList());
                    RepaymentInfo lastRepayment = sortRepaymentInfoParts.get(sortRepaymentInfoParts.size() - 1);
                    if (lastRepayment.getRemainderPrincipal().compareTo(lastRepayment.getPlanEndLoanPrincipal()) <= 0){
                        repaymentInfo.setId(lastRepayment.getId());
                        result = repaymentInfoService.updateByPrimaryKeySelective(repaymentInfo);
                        break;
                    }

                    // 如果不是易鑫的冲销情况,那就只能是部分还款了
                    boolean bLast = true;
                    for (RepaymentInfo r : repaymentInfoParts) {
                        bLast = r.getRelPayDate().compareTo(repaymentInfo.getRelPayDate()) > 0;
                        if (!bLast) {
                            break;
                        }
                    }
                    if (bLast) {
                        //如果当前信息是最新一条,将当期应还本息费减去已还的本、息、费之和，就是当前当期应还
                        BigDecimal principal = repaymentInfoParts.stream().map(r -> r.getRelPrincipal()).reduce(BigDecimal.ZERO, BigDecimal::add);
                        BigDecimal interest = repaymentInfoParts.stream().map(r -> r.getRelInterest()).reduce(BigDecimal.ZERO, BigDecimal::add);
                        BigDecimal fee = repaymentInfoParts.stream().map(r -> r.getRelFee()).reduce(BigDecimal.ZERO, BigDecimal::add);

                        // 设置当期的应还本息费
                        repaymentInfo.setRepayPrincipal(repaymentScheduleOnPeriod.getRepayPrincipal().subtract(principal));
                        if (repaymentInfo.getRepayPrincipal().compareTo(BigDecimal.ZERO) < 0) {
                            logger.info("{}期应还本金已还清", repaymentInfo.getPeriod());
                            break;
                        }
                        repaymentInfo.setRepayInterest(repaymentScheduleOnPeriod.getRepayInterest().subtract(interest));
                        if (repaymentInfo.getRepayInterest().compareTo(BigDecimal.ZERO) < 0) {
                            repaymentInfo.setRepayInterest(BigDecimal.ZERO);
                        }
                        repaymentInfo.setRepayFee(repaymentScheduleOnPeriod.getRepayFee().subtract(fee));
                        if (repaymentInfo.getRepayFee().compareTo(BigDecimal.ZERO) < 0) {
                            repaymentInfo.setRepayInterest(BigDecimal.ZERO);
                        }

                        if (repaymentInfo.getRelPrincipal().compareTo(BigDecimal.ZERO) > 0) {
                            repaymentInfo.setRepayInterest(repaymentInfo.getRelInterest());
                            repaymentInfo.setRepayFee(repaymentInfo.getRelFee());
                        }

                        //插入最新一条部分还款信息
                        result = repaymentInfoService.insert(repaymentInfo);
                        if (result <= 0) {
                            logger.error("实还信息插入或者更新出错");
                        } else {
                            logger.info("执行成功！");
                        }
                        break;
                    }

                    //如果不是最新一条数据，需要将过去的信息重新入库
                    if (!repaymentInfoParts.add(repaymentInfo)) {
                        logger.error("部分还款信息合并失败");
                        break;
                    }

                    repaymentInfoParts.sort(Comparator.comparing(RepaymentInfo::getRelPayDate));
                    BigDecimal relpayPrincipal = repaymentScheduleOnPeriod.getRepayPrincipal();
                    BigDecimal relpayInterest = repaymentScheduleOnPeriod.getRepayInterest();
                    BigDecimal relpayFee = repaymentScheduleOnPeriod.getRepayFee();
                    BigDecimal remainderPrincipal = repaymentScheduleOnPeriod.getBeginLoanPrincipal();
                    BigDecimal remianderInterest = repaymentScheduleOnPeriod.getBeginLoanInterest();
                    BigDecimal remianderFee = repaymentScheduleOnPeriod.getBeginLoanFee();
                    BigDecimal beginRemainderPrincipal = repaymentScheduleOnPeriod.getBeginLoanPrincipal();

                    BigDecimal relPrincipal = BigDecimal.ZERO;
                    BigDecimal relInterest = BigDecimal.ZERO;
                    BigDecimal relFee = BigDecimal.ZERO;

                    for (RepaymentInfo r : repaymentInfoParts) {
                        relPrincipal = relPrincipal.add(r.getRelPrincipal());
                        relInterest = relInterest.add(r.getRelInterest());
                        relFee = relFee.add(r.getRelFee());

                        r.setRepayPrincipal(relpayPrincipal);
                        r.setRepayInterest(relpayInterest);
                        r.setRepayFee(relpayFee);
                        r.setRepayDate(repaymentScheduleOnPeriod.getRepayDate());
                        remainderPrincipal = remainderPrincipal.subtract(relPrincipal);
                        if (remainderPrincipal.compareTo(BigDecimal.ZERO) < 0) {
                            remainderPrincipal = BigDecimal.ZERO;
                        }
                        r.setRemainderPrincipal(remainderPrincipal);

                        r.setPlanBeginLoanPrincipal(beginRemainderPrincipal);
                        beginRemainderPrincipal = beginRemainderPrincipal.subtract(relPrincipal);
                        if (beginRemainderPrincipal.compareTo(BigDecimal.ZERO) < 0) {
                            beginRemainderPrincipal = BigDecimal.ZERO;
                        }

                        remianderInterest = remianderInterest.subtract(relInterest);
                        if (remianderInterest.compareTo(repaymentScheduleOnPeriod.getEndLoanInterest()) < 0) {
                            remianderInterest = repaymentScheduleOnPeriod.getEndLoanInterest();
                        }

                        if (repaymentScheduleOnPeriod.getRepayFee().equals(BigDecimal.ZERO)) {
                            remianderFee = repaymentScheduleOnPeriod.getEndLoanFee();
                        } else {
                            remianderFee = remianderFee.subtract(relFee);
                            if (remianderFee.compareTo(repaymentScheduleOnPeriod.getEndLoanFee()) < 0) {
                                remianderFee = repaymentScheduleOnPeriod.getEndLoanFee();
                            }
                        }

                        if (remainderPrincipal.equals(BigDecimal.ZERO)) {
                            remianderInterest = BigDecimal.ZERO;
                            remianderFee = BigDecimal.ZERO;
                        }
                        r.setRemainderInterest(remianderInterest);
                        r.setRemainderFee(remianderFee);


                        relpayPrincipal = relpayPrincipal.subtract(relPrincipal);
                        relpayInterest = relpayInterest.subtract(relInterest);
                        relpayFee = relpayFee.subtract(relFee);


                        if (r.getRelPayDate().compareTo(repaymentInfo.getRelPayDate()) == 0) {
                            result = repaymentInfoService.insert(r);
                        } else {
                            result = repaymentInfoService.updateByPrimaryKeySelective(r);
                        }

                        if (relpayPrincipal.compareTo(BigDecimal.ZERO) < 0) {
                            relpayPrincipal = BigDecimal.ZERO;
                        }
                        if (relpayInterest.compareTo(BigDecimal.ZERO) < 0) {
                            relpayInterest = BigDecimal.ZERO;
                        }
                        if (relFee.compareTo(BigDecimal.ZERO) < 0) {
                            relFee = BigDecimal.ZERO;
                        }
                    }
                }
            } else {
                //如果当天当期已经有数据了,判断是否有效覆盖
                if (relRepaymentInfo.getTimestamp().compareTo(repaymentInfo.getTimestamp()) > 0) {
                    logger.error("信息已过期");
                    break;
                }else if (relRepaymentInfo.getTimestamp().compareTo(repaymentInfo.getTimestamp()) == 0) {
                    BigDecimal total = relRepaymentInfo.getRelPrincipal().add(relRepaymentInfo.getRelInterest()).add(relRepaymentInfo.getRelFee());
                    if (total.add(totalRelMoney).equals(BigDecimal.ZERO)) {
                        repaymentInfoService.deleteByPrimaryKey(relRepaymentInfo.getId());
                        logger.error("同一个文件2条相反实还抵充");
                        break;
                    }
                }

                relRepaymentInfo.setRelPrincipal(repaymentInfo.getRelPrincipal());
                relRepaymentInfo.setRelInterest(repaymentInfo.getRelInterest());
                relRepaymentInfo.setRelFee(repaymentInfo.getRelFee());
                relRepaymentInfo.setFreeAmount(repaymentInfo.getFreeAmount());
                relRepaymentInfo.setRemainderPrincipal(repaymentInfo.getRemainderPrincipal());
                relRepaymentInfo.setTimestamp(repaymentInfo.getTimestamp());
                relRepaymentInfo.setExtraInfo(repaymentInfo.getExtraInfo());
                relRepaymentInfo.setCurrentLoanBalance(repaymentInfo.getCurrentLoanBalance());
                relRepaymentInfo.setRepayType(repaymentInfo.getRepayType());

                if (relRepaymentInfo.getRelPrincipal().compareTo(relRepaymentInfo.getPlanBeginLoanPrincipal()) == 0) {
                    relRepaymentInfo.setRepayPrincipal(relRepaymentInfo.getRelPrincipal());
                    relRepaymentInfo.setRepayInterest(relRepaymentInfo.getRelInterest());
                    relRepaymentInfo.setRelFee(relRepaymentInfo.getRelFee());
                }
                result = repaymentInfoService.updateByPrimaryKeySelective(relRepaymentInfo);
            }

            if (result <= 0) {
                logger.error("实还信息插入或者更新出错");
            } else {
                logger.info("执行成功！");
            }
            // 校验逾期提前结清情况
//            List<RepaymentInfo> repaymentInfos = repaymentInfoService.selectRepayInfoByLessDate(repaymentInfo.getProjectId(), repaymentInfo.getAssetId(), repaymentInfo.getRepayDate());
//
//            if (PaymentTypeEnum.PREPAYMENT.getType().equals(repaymentInfo.getRepayType())
//                    && repaymentInfos.size() < repaymentInfo.getPeriod()
//                    && repaymentScheduleOnPeriod.getBeginLoanPrincipal().compareTo(repaymentInfo.getRelPrincipal()) < 0) {
//                taskHander.addNextTaskBean(apiTaskBean.getId(), "实还信息校验任务", RepaymentInfoPayOffCheckActuator.class.getSimpleName(), GsonUtils.toString(repaymentInfo));
//                break;
//            }
//            if (repaymentInfo.getRelPrincipal().compareTo(repaymentInfo.getRepayPrincipal()) > 0) {
//                // 当实还本金大约应还本金，对于易鑫来说就是提前结清，需要对最后一期进行校验修正
//                //插入校验任务
//                taskHander.addNextTaskBean(apiTaskBean.getId(), "实还信息校验任务", RepaymentInfoPayOffCheckActuator.class.getSimpleName(), GsonUtils.toString(repaymentInfo));
//            } else {
//
//                if (!loanContractInfo.getVerifyStatus().equals(AssetVerifyStatusEnum.NORMAL.getDesc()) && !loanContractInfo.getVerifyStatus().equals(AssetVerifyStatusEnum.FIXEND.getDesc())) {
//                    taskHander.addNextTaskBean(apiTaskBean.getId(), "实还信息校验任务", RepaymentInfoPayOffCheckActuator.class.getSimpleName(), GsonUtils.toString(repaymentInfo));
//                }
//            }
            // 文件7插入成功，删除实还日期之后的文件10数据
            Map params = new HashMap<>();
            params.put("projectId",repaymentInfo.getProjectId());
            params.put("assetId",repaymentInfo.getAssetId());
            params.put("accountDate",new java.sql.Date((DateUtils.subDay(repaymentInfo.getRelPayDate(), repaymentInfo.getRepayDate()) > 0 ?
                    repaymentInfo.getRepayDate(): repaymentInfo.getRelPayDate()).getTime()));

            assetCheckService.deleteByAccountDate(params);
        } while (false);

    }

    @Override
    public void mqPush(JsonObject jsonObject) {

    }

    private boolean zeroPeriodInsert(RepaymentInfo repaymentInfo) {
        RedissonLockerUtil.lock(repaymentInfo.getAssetId()+":"+repaymentInfo.getPeriod(), TimeUnit.SECONDS,3000);
        logger.info("获取锁：{}",repaymentInfo.getAssetId()+":"+repaymentInfo.getPeriod());
        try {
            int result = 0;
            //如果期数为0，说明是易鑫的罚息数据。对于同一天的罚息数据，应该合并
            RepaymentInfo zeroRepaymentInfo = repaymentInfoService.selectUnionByRelDateAndPeriodAndRepayDate(repaymentInfo.getProjectId(), repaymentInfo.getAssetId(),0, repaymentInfo.getRelPayDate(), repaymentInfo.getRepayDate());
            if (Objects.isNull(zeroRepaymentInfo)) {
                logger.info("新增0期数据");
                result = repaymentInfoService.insert(repaymentInfo);
            } else {
                if("10043".equals(repaymentInfo.getAgencyId())){
                    if(zeroRepaymentInfo.getImportId().equals(repaymentInfo.getImportId())){
                        logger.info("处理汇通0期数据");
                        repaymentInfo.setRelFee(repaymentInfo.getRelFee());
                        repaymentInfo.setId(zeroRepaymentInfo.getId());
                        result = repaymentInfoService.updateRelFeeByZero(repaymentInfo);
                    }else{

                        repaymentInfo.setId(zeroRepaymentInfo.getId());
                        result = repaymentInfoService.updateByPrimaryKeySelective(repaymentInfo);
                    }

                }else {
                    if (zeroRepaymentInfo.getImportId().equals(repaymentInfo.getImportId())) {
                        logger.info("0期数据追加");
                        zeroRepaymentInfo.setRelFee(repaymentInfo.getRelFee().add(zeroRepaymentInfo.getRelFee()));
                        zeroRepaymentInfo.setRelInterest(repaymentInfo.getRelInterest());
                        zeroRepaymentInfo = sumZeroPeriodAdd(repaymentInfo, zeroRepaymentInfo);
                        repaymentInfo.setId(zeroRepaymentInfo.getId());
                        result = repaymentInfoService.updateByPrimaryKeySelective(repaymentInfo);
                    } else {
                        logger.info("0期数据覆盖");
                        repaymentInfo.setId(zeroRepaymentInfo.getId());
                        result = repaymentInfoService.updateByPrimaryKeySelective(repaymentInfo);
                    }
                }
            }
            return result == 1;
        } catch (Exception e){
            logger.error("处理0期相关数据失败",e);
            return false;
        }finally {
            logger.info("释放锁：{}",repaymentInfo.getAssetId()+":"+repaymentInfo.getPeriod());
            RedissonLockerUtil.unlock(repaymentInfo.getAssetId()+":"+repaymentInfo.getPeriod());
        }
    }

    private RepaymentInfo sumZeroPeriodAdd(RepaymentInfo repaymentInfo, RepaymentInfo relRepaymentInfo) {
        BigDecimal zeroPeriodFee = repaymentInfo.getRelFee();
        relRepaymentInfo.setRelFee(relRepaymentInfo.getRelFee().add(zeroPeriodFee));
        return this.fixRepaymentExtraInfo(relRepaymentInfo);
    }

    private RepaymentInfo fixRepaymentExtraInfo(RepaymentInfo repaymentInfo) {
        JsonObject jsonObject = GsonUtils.stringToJson(repaymentInfo.getExtraInfo());
        jsonObject.addProperty(File07Head.relPrincipal, repaymentInfo.getRelPrincipal());
        jsonObject.addProperty(File07Head.relInterest, repaymentInfo.getRelInterest());
        jsonObject.addProperty(File07Head.relFee, repaymentInfo.getRelFee());

        repaymentInfo.setExtraInfo(GsonUtils.toString(jsonObject));
        return repaymentInfo;

    }

}
