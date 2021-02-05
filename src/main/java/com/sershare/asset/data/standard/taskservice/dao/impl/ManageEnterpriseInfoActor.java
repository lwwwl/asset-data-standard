package com.sershare.asset.data.standard.taskservice.dao.impl;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.EnterpriseInfo;
import com.sershare.asset.data.standard.service.task.EnterpriseInfoService;
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
 * @date: 2021/2/1  14:17
 */
@Component("ManageEnterpriseInfoActor")
public class ManageEnterpriseInfoActor implements EntityManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private EnterpriseInfoService enterpriseInfoService;

    @Override
    public void insert(JsonObject jsonObject) {
        logger.info("开始执行EnterpriseInfo数据插入");
        String entityObject = jsonObject.get("entityObject").getAsString();
        EnterpriseInfo enterpriseInfo = GsonUtils.fromString(entityObject, EnterpriseInfo.class);
        EnterpriseInfo existEnterprise = enterpriseInfoService.selectByCreditCode(enterpriseInfo.getAssetId(),enterpriseInfo.getUnifiedCreditCode());
        if (Objects.isNull(existEnterprise)) {
            int result = enterpriseInfoService.insert(enterpriseInfo);
            if (result != 1) {
                logger.error("EnterpriseInfo数据插入失败！数据ID:{}", enterpriseInfo.getId());
            } else {
                logger.info("EnterpriseInfo数据插入成功！数据ID:{}", enterpriseInfo.getId());
            }
        } else {
            enterpriseInfo.setId(existEnterprise.getId());
            enterpriseInfoService.updateByPrimaryKeySelective(enterpriseInfo);
            logger.info("EnterpriseInfo数据更新成功！数据ID:{}", enterpriseInfo.getId());
        }
    }

    @Override
    public void mqPush(JsonObject jsonObject) {

    }

}
