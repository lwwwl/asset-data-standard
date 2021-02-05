package com.sershare.asset.data.standard.taskservice.parser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.AssetCheckInfo;
import com.sershare.asset.data.standard.explain.File10Head;
import com.sershare.asset.data.standard.explain.FileShareHead;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.utils.DateUtils;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;


@Component("ParserAssetCheckInfoActor")
public class ParserAssetCheckInfoActor implements IFileParseActuator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public JsonObject run(JsonElement jsonElement) {
        logger.info("开始执行文件解析");
        if (Objects.isNull(jsonElement)) {
            logger.error("参数错误！");
            return null;
        }
        AssetCheckInfo assetCheckInfo = parseAssetCheckInfo(jsonElement);
        return GsonUtils.objectToJsonTree(assetCheckInfo).getAsJsonObject();
    }

    private AssetCheckInfo parseAssetCheckInfo(JsonElement jsonElement) {
        AssetCheckInfo assetCheckInfo = null;
        do {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            assetCheckInfo = new AssetCheckInfo();
            assetCheckInfo.setExtraInfo(jsonElement.toString());
            assetCheckInfo.setAgencyId(jsonObject.get(FileShareHead.agencyId) == null ? null : jsonObject.get(FileShareHead.agencyId).getAsString());
            assetCheckInfo.setAssetId(jsonObject.get(FileShareHead.assetId) == null ? null : jsonObject.get(FileShareHead.assetId).getAsString());
            assetCheckInfo.setProjectId(jsonObject.get(FileShareHead.projectId) == null ? null : jsonObject.get(FileShareHead.projectId).getAsString());
            assetCheckInfo.setRepayedperiod(jsonObject.get(File10Head.repayedperiod) == null ? null : jsonObject.get(File10Head.repayedperiod).getAsInt());
            assetCheckInfo.setRemainPeriod(jsonObject.get(File10Head.repayedperiod) == null ? null : jsonObject.get(File10Head.repayedperiod).getAsInt());
            assetCheckInfo.setRemainPrincipal(jsonObject.get(File10Head.remainPrincipal) == null ? BigDecimal.ZERO : jsonObject.get(File10Head.remainPrincipal).getAsBigDecimal());
            assetCheckInfo.setRemainInterest(jsonObject.get(File10Head.remainInterest) == null ? BigDecimal.ZERO : jsonObject.get(File10Head.remainInterest).getAsBigDecimal());
            assetCheckInfo.setRemainOthamounts(jsonObject.get(File10Head.remainFee) == null ? BigDecimal.ZERO : jsonObject.get(File10Head.remainFee).getAsBigDecimal());
            assetCheckInfo.setNextPayDate(jsonObject.get(File10Head.nextPayDate) == null ? null : jsonObject.get(File10Head.nextPayDate).getAsString());
            assetCheckInfo.setAssetsStatus(jsonObject.get(File10Head.assetsStatus) == null ? null : jsonObject.get(File10Head.assetsStatus).getAsString());
            assetCheckInfo.setSettleReason(jsonObject.get(File10Head.settleReason) == null ? null : jsonObject.get(File10Head.settleReason).getAsString());
            String curr = jsonObject.get(File10Head.currentOverduePrincipal) == null ? null : jsonObject.get(File10Head.currentOverduePrincipal).getAsString();
            assetCheckInfo.setCurrentOverduePrincipal(StringUtils.isBlank(curr)?BigDecimal.ZERO:new BigDecimal(curr));
            String fee = jsonObject.get(File10Head.currentOverdueFee) == null ? null : jsonObject.get(File10Head.currentOverdueFee).getAsString();
            assetCheckInfo.setCurrentOverdueFee(StringUtils.isBlank(fee)?BigDecimal.ZERO:new BigDecimal(fee));
            String currentOverdueDays = jsonObject.get(File10Head.currentOverdueDays) == null ? null : jsonObject.get(File10Head.currentOverdueDays).getAsString();
            assetCheckInfo.setCurrentOverdueDays(StringUtils.isBlank(currentOverdueDays)?0:Integer.valueOf(currentOverdueDays));
            String accumOverdueDays = jsonObject.get(File10Head.accumOverdueDays) == null ? null : jsonObject.get(File10Head.accumOverdueDays).getAsString();
            assetCheckInfo.setAccumOverdueDays(StringUtils.isBlank(accumOverdueDays)?0:Integer.valueOf(currentOverdueDays));
            String hisAccumOverdueDays = jsonObject.get(File10Head.hisAccumOverdueDays) == null ? null : jsonObject.get(File10Head.hisAccumOverdueDays).getAsString();
            assetCheckInfo.setHisAccumOverdueDays(StringUtils.isBlank(hisAccumOverdueDays)?0:Integer.valueOf(currentOverdueDays));
            String hisOverdueMdays = jsonObject.get(File10Head.hisOverdueMdays) == null ? null : jsonObject.get(File10Head.hisOverdueMdays).getAsString();
            assetCheckInfo.setHisOverdueMdays(StringUtils.isBlank(hisOverdueMdays)?0:Integer.valueOf(currentOverdueDays));
            String currentOverduePeriod = jsonObject.get(File10Head.currentOverduePeriod) == null ? null : jsonObject.get(File10Head.currentOverduePeriod).getAsString();
            assetCheckInfo.setCurrentOverduePeriod(StringUtils.isBlank(currentOverduePeriod)?0:Integer.valueOf(currentOverdueDays));
            String accumOverduePeriod = jsonObject.get(File10Head.accumOverduePeriod) == null ? null : jsonObject.get(File10Head.accumOverduePeriod).getAsString();
            assetCheckInfo.setCurrentOverduePeriod(StringUtils.isBlank(accumOverduePeriod)?0:Integer.valueOf(currentOverdueDays));
            String hisOverdueMperiods = jsonObject.get(File10Head.hisOverdueMperiods) == null ? null : jsonObject.get(File10Head.hisOverdueMperiods).getAsString();
            assetCheckInfo.setCurrentOverduePeriod(StringUtils.isBlank(hisOverdueMperiods)?0:Integer.valueOf(currentOverdueDays));
            String hisOverdueMprincipal = jsonObject.get(File10Head.hisOverdueMprincipal) == null ? null : jsonObject.get(File10Head.hisOverdueMprincipal).getAsString();
            assetCheckInfo.setCurrentOverduePeriod(StringUtils.isBlank(hisOverdueMprincipal)?0:Integer.valueOf(currentOverdueDays));
            assetCheckInfo.setExtractDate(DateUtils.string2Date(jsonObject.get(File10Head.extractDate) == null ? null : jsonObject.get(File10Head.extractDate).getAsString()));
        } while (false);
        return assetCheckInfo;
    }
}