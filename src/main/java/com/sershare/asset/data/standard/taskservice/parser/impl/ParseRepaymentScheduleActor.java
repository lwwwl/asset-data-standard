package com.sershare.asset.data.standard.taskservice.parser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.RepaymentSchedule;
import com.sershare.asset.data.standard.explain.File05Head;
import com.sershare.asset.data.standard.explain.File07Head;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.utils.DateUtils;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Component("ParseRepaymentScheduleActor")
public class ParseRepaymentScheduleActor implements IFileParseActuator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public JsonObject run(JsonElement jsonElement) {
        logger.info("开始执行文件解析");
        if (Objects.isNull(jsonElement)) {
            logger.error("参数错误！");
            return null;
        }
        RepaymentSchedule repaymentSchedule = parseRepaymentSchedule(jsonElement);
        return GsonUtils.objectToJsonTree(repaymentSchedule).getAsJsonObject();
    }

    private RepaymentSchedule parseRepaymentSchedule(JsonElement jsonElement) {
        RepaymentSchedule repaymentSchedule = new RepaymentSchedule();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        repaymentSchedule.setExtraInfo(jsonElement.toString());
        repaymentSchedule.setImportId(jsonObject.get(File05Head.importId) == null ? null : jsonObject.get(File05Head.importId).getAsString());
        repaymentSchedule.setAgencyId(jsonObject.get(File05Head.agencyId) == null ? null : jsonObject.get(File05Head.agencyId).getAsString());
        repaymentSchedule.setAssetId(jsonObject.get(File05Head.assetId) == null ? null : jsonObject.get(File05Head.assetId).getAsString());
        repaymentSchedule.setProjectId(jsonObject.get(File05Head.projectId) == null ? null : jsonObject.get(File05Head.projectId).getAsString());

        repaymentSchedule.setRepayDate(DateUtils.string2Date(jsonObject.get(File05Head.repayDate) == null ? null : jsonObject.get(File05Head.repayDate).getAsString()));

        repaymentSchedule.setRepayPrincipal(jsonObject.get(File05Head.repayPrincipal).getAsBigDecimal());
        repaymentSchedule.setRepayInterest(jsonObject.get(File05Head.repayInterest).getAsBigDecimal());
        repaymentSchedule.setRepayFee(jsonObject.get(File05Head.repayFee).getAsBigDecimal());

        repaymentSchedule.setExecuteDate(DateUtils.string2Date(jsonObject.get(File05Head.executeDate) == null ? null : jsonObject.get(File05Head.executeDate).getAsString()));
        repaymentSchedule.setTimestamp(new Date(jsonObject.get(File05Head.timestamp).getAsLong()));
        if(jsonObject.has(File07Head.repayPenalty)){
            repaymentSchedule.setRepayPenalty(jsonObject.get(File07Head.repayPenalty).getAsBigDecimal());
        }else {
            repaymentSchedule.setRepayPenalty(BigDecimal.ZERO);
        }
        repaymentSchedule.setPeriod(jsonObject.get(File05Head.period).getAsInt());
        return repaymentSchedule;
    }

}
