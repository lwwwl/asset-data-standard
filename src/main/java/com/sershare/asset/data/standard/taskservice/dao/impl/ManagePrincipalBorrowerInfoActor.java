package com.sershare.asset.data.standard.taskservice.dao.impl;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.PrincipalBorrowerInfo;
import com.sershare.asset.data.standard.service.task.PrincipalBorrowerInfoService;
import com.sershare.asset.data.standard.taskservice.dao.EntityManager;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/1  15:12
 */
public class ManagePrincipalBorrowerInfoActor implements EntityManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PrincipalBorrowerInfoService principalBorrowerInfoService;

    @Override
    public void insert(JsonObject jsonObject) {
        logger.info("开始执行PrincipalBorrowerInfo数据插入");
        String entityObject = jsonObject.get("entityObject").getAsString();
        PrincipalBorrowerInfo principalBorrowerInfo = GsonUtils.fromString(entityObject, PrincipalBorrowerInfo.class);
        PrincipalBorrowerInfo exitRepaymentInfo = principalBorrowerInfoService.selectByUnionKey(principalBorrowerInfo.getProjectId(), principalBorrowerInfo.getAssetId());
        if (Objects.isNull(exitRepaymentInfo)) {
            int result = principalBorrowerInfoService.insert(principalBorrowerInfo);
            if (result != 1) {
                logger.error("PrincipalBorrowerInfo数据插入失败！数据ID:{}", principalBorrowerInfo.getId());
            } else {
                logger.info("PrincipalBorrowerInfo数据插入成功！数据ID:{}", principalBorrowerInfo.getId());
            }
        } else {
            principalBorrowerInfo.setId(exitRepaymentInfo.getId());
            principalBorrowerInfoService.updateByPrimaryKeySelective(principalBorrowerInfo);
            logger.info("PrincipalBorrowerInfo数据更新成功！数据ID:{}", principalBorrowerInfo.getId());
        }
    }

    @Override
    public void mqPush(JsonObject jsonObject) {

    }

}
