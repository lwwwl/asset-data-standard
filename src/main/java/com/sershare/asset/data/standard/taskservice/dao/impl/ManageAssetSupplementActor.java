package com.sershare.asset.data.standard.taskservice.dao.impl;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.AssetSupplement;
import com.sershare.asset.data.standard.service.task.AssetSupplementService;
import com.sershare.asset.data.standard.taskservice.dao.EntityManager;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/1  11:37
 */
public class ManageAssetSupplementActor implements EntityManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AssetSupplementService assetSupplementService;

    @Override
    public void insert(JsonObject jsonObject) {
        logger.info("开始执行AssetSupplement数据插入");
        String entityObject = jsonObject.get("entityObject").getAsString();
        AssetSupplement assetSupplement = GsonUtils.fromString(entityObject, AssetSupplement.class);
        AssetSupplement exitAssetSupplement = assetSupplementService.selectByUnionKey(assetSupplement.getProjectId(), assetSupplement.getAssetId(), assetSupplement.getAgencyId(),assetSupplement.getTradedate());
        if (Objects.isNull(exitAssetSupplement)) {
            int result = assetSupplementService.insert(assetSupplement);
            if (result <= 0) {
                logger.error("AssetSupplement数据插入失败！数据ID:{}", assetSupplement.getId());
            } else {
                logger.info("AssetSupplement数据插入成功！数据ID:{}", assetSupplement.getId());
            }
        } else {
            assetSupplement.setId(exitAssetSupplement.getId());
            assetSupplementService.updateByPrimaryKeySelective(assetSupplement);
            logger.info("AssetSupplement数据更新成功！数据ID:{}", assetSupplement.getId());
        }
    }

    @Override
    public void mqPush(JsonObject jsonObject) {

    }
}
