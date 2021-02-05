package com.sershare.asset.data.standard.taskservice.dao.impl;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.ContactPersonInfo;
import com.sershare.asset.data.standard.service.task.ContactPersonInfoService;
import com.sershare.asset.data.standard.taskservice.dao.EntityManager;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/1  11:53
 */

@Component("ManageContactPersonInfoActor")
public class ManageContactPersonInfoActor implements EntityManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    ContactPersonInfoService contactPersonInfoService;

    @Override
    public void insert(JsonObject jsonObject) {
        logger.info("开始执行ContactPersonInfo数据插入");
        String entityObject = jsonObject.get("entityObject").getAsString();
        ContactPersonInfo contactPersonInfo = GsonUtils.fromString(entityObject, ContactPersonInfo.class);
        ContactPersonInfo exitLoanContract = contactPersonInfoService.selectByUnionKey(contactPersonInfo.getProjectId(), contactPersonInfo.getAssetId(),contactPersonInfo.getPhoneNum());
        if (Objects.isNull(exitLoanContract)) {
            int result = contactPersonInfoService.insert(contactPersonInfo);
            if (result != 1) {
                logger.error("ContactPersonInfo数据插入失败！数据ID:{}", contactPersonInfo.getId());
            } else {
                logger.info("ContactPersonInfo数据插入成功！数据ID:{}", contactPersonInfo.getId());
            }
        } else {
            contactPersonInfo.setId(exitLoanContract.getId());
            contactPersonInfoService.updateByPrimaryKeySelective(contactPersonInfo);
            logger.info("ContactPersonInfo数据更新成功！数据ID:{}", contactPersonInfo.getId());
        }
    }

    @Override
    public void mqPush(JsonObject jsonObject) {

    }

}
