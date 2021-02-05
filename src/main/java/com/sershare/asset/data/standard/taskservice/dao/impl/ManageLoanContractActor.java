package com.sershare.asset.data.standard.taskservice.dao.impl;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.LoanContractInfo;
import com.sershare.asset.data.standard.service.task.LoanContractInfoService;
import com.sershare.asset.data.standard.taskservice.dao.EntityManager;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("ManageLoanContractActor")
public class ManageLoanContractActor implements EntityManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoanContractInfoService loanContractInfoService;

    @Override
    public void insert(JsonObject jsonObject) {
        logger.info("开始执行LoanContractInfo数据插入");
        String entityObject = jsonObject.get("entityObject").getAsString();
        LoanContractInfo loanContractInfo = GsonUtils.fromString(entityObject, LoanContractInfo.class);
        LoanContractInfo exitLoanContract = loanContractInfoService.selectByUnionKey(loanContractInfo.getProjectId(), loanContractInfo.getAssetId());
        if (Objects.isNull(exitLoanContract)) {
            int result = loanContractInfoService.insert(loanContractInfo);
            if (result != 1) {
                logger.error("LoanContractInfo数据插入失败！数据ID:{}", loanContractInfo.getId());
            } else {
                logger.info("LoanContractInfo数据插入成功！数据ID:{}", loanContractInfo.getId());
            }
        } else {
            loanContractInfo.setId(exitLoanContract.getId());
            loanContractInfoService.updateByPrimaryKeySelective(loanContractInfo);
            logger.info("LoanContractInfo数据更新成功！数据ID:{}", loanContractInfo.getId());
        }
    }

    @Override
    public void mqPush(JsonObject jsonObject) {

    }


}
