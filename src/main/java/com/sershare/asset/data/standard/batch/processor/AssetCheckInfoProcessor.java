package com.sershare.asset.data.standard.batch.processor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sershare.asset.data.standard.entity.AssetCheckInfo;
import com.sershare.asset.data.standard.explain.File10Head;
import com.sershare.asset.data.standard.explain.FileShareHead;
import com.sershare.asset.data.standard.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.reflections.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/3  15:01
 */
@Component("assetCheckInfoProcessor")
public class AssetCheckInfoProcessor implements ItemProcessor<String, AssetCheckInfo> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public AssetCheckInfo process(String line) {
        logger.info("Batch Process阶段开始执行数据解析");
        if (Objects.isNull(line)) {
            logger.error("参数错误！");
            return null;
        }
        String[] elements = line.split(",");
        Set<Field> fields = ReflectionUtils.getAllFields(AssetCheckInfo.class);
        JsonObject parseLineObject = new JsonObject();
        if (elements.length != fields.size()) {
            logger.error("参数数量不匹配！AssetCheckInfo参数数量：{}, Elements当前已有数量：{}", fields.size(), elements.length);
        } else {
            parseLineObject = parseLine(elements);
        }
        return parseAssetCheckInfo(parseLineObject);

    }

    private JsonObject parseLine(String[] elements) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(FileShareHead.projectId, JsonParser.parseString(elements[0]));
        jsonObject.add(FileShareHead.agencyId, JsonParser.parseString(elements[1]));
        jsonObject.add(FileShareHead.assetId, JsonParser.parseString(elements[2]));
        jsonObject.add(File10Head.changeRepayPlan, JsonParser.parseString(elements[3]));
        jsonObject.add(File10Head.changeDate, JsonParser.parseString(elements[4]));
        jsonObject.add(File10Head.loanTotalAmount, JsonParser.parseString(elements[5]));
        jsonObject.add(File10Head.loanYearInterestRate, JsonParser.parseString(elements[6]));
        jsonObject.add(File10Head.periods, JsonParser.parseString(elements[7]));
        jsonObject.add(File10Head.repayedperiod, JsonParser.parseString(elements[8]));
        jsonObject.add(File10Head.remainPeriod, JsonParser.parseString(elements[9]));
        jsonObject.add(File10Head.remainPrincipal, JsonParser.parseString(elements[10]));
        jsonObject.add(File10Head.remainInterest, JsonParser.parseString(elements[11]));
        jsonObject.add(File10Head.remainFee, JsonParser.parseString(elements[12]));
        jsonObject.add(File10Head.nextPayDate, JsonParser.parseString(elements[13]));
        jsonObject.add(File10Head.assetsStatus, JsonParser.parseString(elements[14]));
        jsonObject.add(File10Head.settleReason, JsonParser.parseString(elements[15]));
        jsonObject.add(File10Head.currentOverduePrincipal, JsonParser.parseString(elements[16]));
        jsonObject.add(File10Head.currentOverdueInterest, JsonParser.parseString(elements[17]));
        jsonObject.add(File10Head.currentOverdueFee, JsonParser.parseString(elements[18]));
        jsonObject.add(File10Head.currentOverdueDays, JsonParser.parseString(elements[19]));
        jsonObject.add(File10Head.accumOverdueDays, JsonParser.parseString(elements[20]));
        jsonObject.add(File10Head.hisAccumOverdueDays, JsonParser.parseString(elements[21]));
        jsonObject.add(File10Head.hisOverdueMdays, JsonParser.parseString(elements[22]));
        jsonObject.add(File10Head.currentOverduePeriod, JsonParser.parseString(elements[23]));
        jsonObject.add(File10Head.accumOverduePeriod, JsonParser.parseString(elements[24]));
        jsonObject.add(File10Head.hisOverdueMperiods, JsonParser.parseString(elements[25]));
        jsonObject.add(File10Head.hisOverdueMprincipal, JsonParser.parseString(elements[26]));
        jsonObject.add(File10Head.extractDate, JsonParser.parseString(elements[27]));
        return jsonObject;
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
