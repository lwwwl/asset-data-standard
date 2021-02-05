package com.sershare.asset.data.standard.taskservice.parser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.AssetSupplement;
import com.sershare.asset.data.standard.explain.File09Head;
import com.sershare.asset.data.standard.explain.FileShareHead;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/1  11:30
 */
@Component("ParseAssetSupplementActor")
public class ParseAssetSupplementActor implements IFileParseActuator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public JsonObject run(JsonElement jsonElement) {
        logger.info("开始执行文件解析");
        if (Objects.isNull(jsonElement)) {
            logger.info("参数错误！");
            return null;
        }
        AssetSupplement assetSupplement = parseAssetSupplement(jsonElement);
        return GsonUtils.objectToJsonTree(assetSupplement).getAsJsonObject();
    }

    public AssetSupplement parseAssetSupplement(JsonElement jsonElement){
        AssetSupplement assetSupplement = new AssetSupplement();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        assetSupplement.setAgencyId(jsonObject.get(FileShareHead.agencyId).getAsString());
        assetSupplement.setAssetId(jsonObject.get(FileShareHead.assetId).getAsString());
        assetSupplement.setProjectId(jsonObject.get(FileShareHead.projectId).getAsString());
        assetSupplement.setTradetype(jsonObject.get(File09Head.tradeType).getAsString());
        assetSupplement.setTradedate(jsonObject.get(File09Head.tradeDate).getAsString());
        assetSupplement.setTradereason(jsonObject.get(File09Head.tradeReason).getAsString());
        assetSupplement.setTradeTolAmounts(jsonObject.get(File09Head.tradeTolAmounts).getAsBigDecimal());
        assetSupplement.setPrincipal(jsonObject.get(File09Head.principal).getAsBigDecimal());
        assetSupplement.setInterest(jsonObject.get(File09Head.interest).getAsBigDecimal());
        assetSupplement.setOthFee(jsonObject.get(File09Head.othFee).getAsBigDecimal());
        assetSupplement.setPunishInterest(jsonObject.get(File09Head.punishInterest).getAsBigDecimal());
        return assetSupplement;
    }

}
