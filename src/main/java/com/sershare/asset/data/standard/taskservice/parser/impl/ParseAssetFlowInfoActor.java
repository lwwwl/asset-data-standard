package com.sershare.asset.data.standard.taskservice.parser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.AssetPayFlow;
import com.sershare.asset.data.standard.explain.File06Head;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/1  11:07
 */
@Component("ParseAssetFlowInfoActor")
public class ParseAssetFlowInfoActor implements IFileParseActuator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public JsonObject run(JsonElement jsonElement) {
        logger.info("开始执行文件解析");
        if (Objects.isNull(jsonElement)) {
            logger.info("参数错误！");
            return null;
        }
        AssetPayFlow assetPayFlow = parseAssetPayFlow(jsonElement);
        return GsonUtils.objectToJsonTree(assetPayFlow).getAsJsonObject();
    }

    public AssetPayFlow parseAssetPayFlow(JsonElement jsonElement) {
        AssetPayFlow assetPayFlow = new AssetPayFlow();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        assetPayFlow.setExtraInfo(jsonElement.toString());
        assetPayFlow.setAgencyId(jsonObject.get(File06Head.agencyId) == null? null : jsonObject.get(File06Head.agencyId).getAsString());
        assetPayFlow.setAssetId(jsonObject.get(File06Head.assetId) == null? null : jsonObject.get(File06Head.assetId).getAsString());
        assetPayFlow.setProjectId(jsonObject.get(File06Head.projectId) == null? null : jsonObject.get(File06Head.projectId).getAsString());
        assetPayFlow.setTradeChannel(jsonObject.get(File06Head.tradeChannel) == null? null : jsonObject.get(File06Head.tradeChannel).getAsString());
        assetPayFlow.setTradeType(jsonObject.get(File06Head.tradeType) == null? null : jsonObject.get(File06Head.tradeType).getAsString());
        assetPayFlow.setTradeStatus(jsonObject.get(File06Head.tradeStatus) == null? null : jsonObject.get(File06Head.tradeStatus).getAsString());
        assetPayFlow.setName(jsonObject.get(File06Head.name) == null? null : jsonObject.get(File06Head.name).getAsString());
        assetPayFlow.setBankAccount(jsonObject.get(File06Head.accoount) == null? "" : jsonObject.get(File06Head.accoount).getAsString());
        assetPayFlow.setOrderAmount(jsonObject.get(File06Head.orderAmount) == null? BigDecimal.ZERO : jsonObject.get(File06Head.orderAmount).getAsBigDecimal());
        assetPayFlow.setTradeTime(jsonObject.get(File06Head.tradeTime) == null? null : jsonObject.get(File06Head.tradeTime).getAsString());
        assetPayFlow.setTradeCurrency(jsonObject.get(File06Head.tradeCurrency) == null? null : jsonObject.get(File06Head.tradeCurrency).getAsString());
        assetPayFlow.setOrderId(jsonObject.get(File06Head.orderId) == null? null : jsonObject.get(File06Head.orderId).getAsString());
        assetPayFlow.setTradDesc(jsonObject.get(File06Head.tradeDesc) == null? null : jsonObject.get(File06Head.tradeDesc).getAsString());
        return assetPayFlow;
    }

}
