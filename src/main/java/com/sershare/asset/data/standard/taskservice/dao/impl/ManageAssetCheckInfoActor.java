package com.sershare.asset.data.standard.taskservice.dao.impl;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.AssetCheckInfo;
import com.sershare.asset.data.standard.service.task.AssetCheckInfoService;
import com.sershare.asset.data.standard.taskservice.dao.EntityManager;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 数据库插入及mq推送
 * @author: i_laowei
 * @date: 2021/1/28  16:24
 */

@Component("ManageAssetCheckInfoActor")
public class ManageAssetCheckInfoActor implements EntityManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AssetCheckInfoService assetCheckInfoService;

    @Override
    public void insert(JsonObject jsonObject) {
        logger.info("开始执行AssetCheckInfo数据插入");
        String entityObject = jsonObject.get("entityObject").getAsString();
        AssetCheckInfo assetCheckInfo = GsonUtils.fromString(entityObject, AssetCheckInfo.class);
        int result = assetCheckInfoService.insertSelective(assetCheckInfo);
        if (result != 1) {
            logger.error("AssetCheckInfo数据插入失败！数据ID:{}", assetCheckInfo.getId());
        } else {
            logger.info("AssetCheckInfo数据插入成功！数据ID:{}", assetCheckInfo.getId());
        }
    }

    @Override
    public void mqPush(JsonObject jsonObject) {
        logger.info("");
        //todo mq推送
    }

}
