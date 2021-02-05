package com.sershare.asset.data.standard.taskservice.dao.impl;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.RepaymentSchedule;
import com.sershare.asset.data.standard.service.task.RepaymentScheduleInputService;
import com.sershare.asset.data.standard.taskservice.dao.EntityManager;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/1  16:23
 */
@Component("ManageRepaymentScheduleActor")
public class ManageRepaymentScheduleActor implements EntityManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RepaymentScheduleInputService repaymentScheduleInputService;
    @Override
    public void insert(JsonObject jsonObject) {
        logger.info("开始执行RepaymentSchedule数据插入");
        String entityObject = jsonObject.get("entityObject").getAsString();
        RepaymentSchedule repaymentSchedule = GsonUtils.fromString(entityObject, RepaymentSchedule.class);
        RepaymentSchedule exitRepaymentSchedule = repaymentScheduleInputService.selectByUnionKey(repaymentSchedule.getProjectId(), repaymentSchedule.getAssetId(), repaymentSchedule.getPeriod());
        if (Objects.isNull(exitRepaymentSchedule)) {
            int result = repaymentScheduleInputService.insert(repaymentSchedule);
            if (result != 1) {
                logger.error("RepaymentSchedule数据插入失败！数据ID:{}", repaymentSchedule.getId());
            } else {
                logger.info("RepaymentSchedule数据插入成功！数据ID:{}", repaymentSchedule.getId());
            }
        } else {
            repaymentSchedule.setId(exitRepaymentSchedule.getId());
            repaymentScheduleInputService.updateByPrimaryKeySelective(repaymentSchedule);
            logger.info("RepaymentSchedule数据更新成功！数据ID:{}", repaymentSchedule.getId());
        }
    }

    @Override
    public void mqPush(JsonObject jsonObject) {

    }
}
