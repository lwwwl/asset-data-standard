package com.sershare.asset.data.standard.taskservice.dao.impl;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.AssetPayFlow;
import com.sershare.asset.data.standard.service.task.AssetPayFlowService;
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
 * @date: 2021/2/1  11:18
 */
@Component("ManageAssetFlowInfoActor")
public class ManageAssetFlowInfoActor implements EntityManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    AssetPayFlowService assetPayFlowService;

    @Override
    public void insert(JsonObject jsonObject) {
        logger.info("开始执行AssetPayFlow数据插入");
        String entityObject = jsonObject.get("entityObject").getAsString();
        AssetPayFlow assetPayFlow = GsonUtils.fromString(entityObject, AssetPayFlow.class);
        AssetPayFlow exitAssetPayFlow = assetPayFlowService.selectByUnionKey(assetPayFlow.getProjectId(), assetPayFlow.getAssetId(), assetPayFlow.getAgencyId(),assetPayFlow.getTradeTime(),assetPayFlow.getOrderId());
        if (Objects.isNull(exitAssetPayFlow)) {
            int result = assetPayFlowService.insert(assetPayFlow);
            if (result <= 0) {
                logger.error("AssetDisposal数据插入失败！数据ID:{}", assetPayFlow.getId());
            } else {
                logger.info("AssetDisposal数据插入成功！数据ID:{}", assetPayFlow.getId());
            }
        } else {
            assetPayFlow.setId(exitAssetPayFlow.getId());
            assetPayFlowService.updateByPrimaryKeySelective(assetPayFlow);
            logger.info("AssetDisposal数据更新成功！数据ID:{}", assetPayFlow.getId());
        }
    }

    @Override
    public void mqPush(JsonObject jsonObject) {

    }

}
