package com.sershare.asset.data.standard.taskservice.dao.impl;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.AssetDisposal;
import com.sershare.asset.data.standard.service.task.AssetDisposalService;
import com.sershare.asset.data.standard.taskservice.dao.EntityManager;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/1/29  10:26
 */
@Component("ManageAssetDisposalActor")
public class ManageAssetDisposalActor implements EntityManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AssetDisposalService assetDisposalService;

    @Override
    public void insert(JsonObject jsonObject) {
        logger.info("开始执行AssetCheckInfo数据插入");
        String entityObject = jsonObject.get("entityObject").getAsString();
        AssetDisposal assetDisposal = GsonUtils.fromString(entityObject, AssetDisposal.class);
        AssetDisposal exitAssetDisposal = assetDisposalService.selectByUnionKey(assetDisposal.getProjectId(), assetDisposal.getAssetId(), assetDisposal.getAgencyId());
        if (exitAssetDisposal == null) {
            int result = assetDisposalService.insert(assetDisposal);
            if (result <= 0) {
                logger.error("AssetDisposal数据插入失败！数据ID:{}", assetDisposal.getId());
            } else {
                logger.info("AssetDisposal数据插入成功！数据ID:{}", assetDisposal.getId());
            }
        } else {
            assetDisposal.setId(exitAssetDisposal.getId());
            assetDisposalService.updateByPrimaryKeySelective(assetDisposal);
            logger.info("AssetDisposal数据更新成功！数据ID:{}", assetDisposal.getId());
        }
    }

    @Override
    public void mqPush(JsonObject jsonObject) {

    }

}
