package com.sershare.asset.data.standard.taskservice.parser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.RepaymentInfo;
import com.sershare.asset.data.standard.entity.RepaymentSchedule;
import com.sershare.asset.data.standard.explain.File07Head;
import com.sershare.asset.data.standard.service.task.RepaymentScheduleService;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.utils.DateUtils;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Component("ParseRepaymentInfoSecActor")
public class ParseRepaymentInfoSecActor implements IFileParseActuator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RepaymentScheduleService repaymentScheduleService;

    @Override
    public JsonObject run(JsonElement jsonElement) {
        logger.info("开始执行文件解析");
        if (Objects.isNull(jsonElement)) {
            logger.error("参数错误！");
            return null;
        }
        RepaymentInfo repaymentInfo = parseRepaymentInfo(jsonElement);
        return GsonUtils.objectToJsonTree(repaymentInfo).getAsJsonObject();
    }

    private RepaymentInfo parseRepaymentInfo(JsonElement jsonElement) {
        RepaymentInfo repaymentInfo = null;
        do {
            if (jsonElement == null) {
                break;
            }
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            repaymentInfo = new RepaymentInfo();

            repaymentInfo.setImportId(jsonObject.get(File07Head.importId) == null ? null : jsonObject.get(File07Head.importId).getAsString());
            repaymentInfo.setProjectId(jsonObject.get(File07Head.projectId) == null ? null : jsonObject.get(File07Head.projectId).getAsString());
            repaymentInfo.setAgencyId(jsonObject.get(File07Head.agencyId) == null ? null : jsonObject.get(File07Head.agencyId).getAsString());
            repaymentInfo.setAssetId(jsonObject.get(File07Head.assetId) == null ? null : jsonObject.get(File07Head.assetId).getAsString());
            repaymentInfo.setPeriod(jsonObject.get(File07Head.period) == null ? null : jsonObject.get(File07Head.period).getAsInt());
            repaymentInfo.setRepayDate(DateUtils.string2Date(jsonObject.get(File07Head.repayDate) == null ? null : jsonObject.get(File07Head.repayDate).getAsString()));
            repaymentInfo.setRelPayDate(DateUtils.string2Date(jsonObject.get(File07Head.relPayDate) == null ? null : jsonObject.get(File07Head.relPayDate).getAsString()));
            RepaymentSchedule repaymentScheduleOnPeriod = null;
            if(!(repaymentInfo.getPeriod() == 0)){
                repaymentScheduleOnPeriod = repaymentScheduleService.selectByUnionKey(repaymentInfo.getProjectId(), repaymentInfo.getAssetId(), repaymentInfo.getRepayDate());
                if (Objects.isNull(repaymentScheduleOnPeriod) || !repaymentInfo.getPeriod().equals(repaymentScheduleOnPeriod.getPeriod())) {
                    //根据期次查询出当期的还款计划
                    repaymentScheduleOnPeriod = repaymentScheduleService.selectListByUnionKeyAndPeriod(repaymentInfo.getProjectId(), repaymentInfo.getAssetId(), repaymentInfo.getPeriod());
                }
                if (Objects.isNull(repaymentScheduleOnPeriod)) {
                    return null;
                }
                //根据应还日查询出当期的还款计划
                repaymentInfo.initByRepaymentSchedule(repaymentScheduleOnPeriod);
            }
            repaymentInfo.setRelPrincipal(jsonObject.get(File07Head.relPrincipal).getAsBigDecimal());
            repaymentInfo.setRelInterest(jsonObject.get(File07Head.relInterest).getAsBigDecimal());
            repaymentInfo.setRelFee(jsonObject.get(File07Head.relFee).getAsBigDecimal());
            String realInterestRate = jsonObject.get(File07Head.realInterest) == null ? null : jsonObject.get(File07Head.realInterest).getAsString();
            repaymentInfo.setRealInterestRate(StringUtils.isBlank(realInterestRate)? BigDecimal.ZERO:new BigDecimal(realInterestRate));
            repaymentInfo.setRepayPrincipal(jsonObject.get(File07Head.repayPrincipal).getAsBigDecimal());
            repaymentInfo.setRepayInterest(jsonObject.get(File07Head.repayInterest).getAsBigDecimal());
            repaymentInfo.setRepayFee(jsonObject.get(File07Head.repayFee).getAsBigDecimal());
            if(jsonObject.has(File07Head.repayPenalty)){
                repaymentInfo.setRepayPenalty(jsonObject.get(File07Head.repayPenalty).getAsBigDecimal());
            }else {
                repaymentInfo.setRepayPenalty(BigDecimal.ZERO);
            }
            if(jsonObject.has(File07Head.reLPenalty)){
                repaymentInfo.setRelPenalty(jsonObject.get(File07Head.reLPenalty).getAsBigDecimal());
            }else {
                repaymentInfo.setRelPenalty(BigDecimal.ZERO);
            }
            repaymentInfo.setTimestamp(new Timestamp(jsonObject.get(File07Head.timestamp).getAsLong()));
            if(!jsonObject.has(File07Head.freeAmount)){
                repaymentInfo.setFreeAmount(BigDecimal.ZERO);
            }else {
                String freeAmountEle = jsonObject.get(File07Head.freeAmount) == null ? null : jsonObject.get(File07Head.freeAmount).getAsString();
                BigDecimal freeAmount = StringUtils.isBlank(freeAmountEle)  ? BigDecimal.ZERO : new BigDecimal(freeAmountEle);
                repaymentInfo.setFreeAmount(freeAmount);
            }
            repaymentInfo.setExtraInfo(jsonObject.toString());
            repaymentInfo.setRepayType(jsonObject.get(File07Head.paymentType) == null ? null : jsonObject.get(File07Head.paymentType).getAsString());
            String currentLoanBalance = jsonObject.get(File07Head.currentLoanBalance) == null ? null : jsonObject.get(File07Head.currentLoanBalance).getAsString();
            repaymentInfo.setCurrentLoanBalance(StringUtils.isBlank(currentLoanBalance)?BigDecimal.ZERO:new BigDecimal(currentLoanBalance));
        } while (false);
        return repaymentInfo;
    }

}
