package com.sershare.asset.data.standard.taskservice.parser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.ProjectCheck;
import com.sershare.asset.data.standard.explain.File11Head;
import com.sershare.asset.data.standard.explain.FileShareHead;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.utils.DateUtils;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/1  15:16
 */
@Component("ParseProjectCheckActor")
public class ParseProjectCheckActor implements IFileParseActuator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public JsonObject run(JsonElement jsonElement) {
        logger.info("开始执行文件解析");
        if (Objects.isNull(jsonElement)) {
            logger.error("参数错误！");
            return null;
        }
        ProjectCheck projectCheck = parseProjectCheck(jsonElement);
        return GsonUtils.objectToJsonTree(projectCheck).getAsJsonObject();
    }

    public ProjectCheck parseProjectCheck(JsonElement jsonElement){
        ProjectCheck projectCheck = new ProjectCheck();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        projectCheck.setExtraInfo(jsonElement.toString());
        projectCheck.setAgencyId(jsonObject.get(FileShareHead.agencyId).getAsString());
        projectCheck.setProjectId(jsonObject.get(FileShareHead.projectId).getAsString());
        projectCheck.setLoanSums(jsonObject.get(File11Head.loanSums).getAsInt());
        projectCheck.setLoanContractTolAmounts(jsonObject.get(File11Head.loanContractTolAmounts).getAsBigDecimal());
        projectCheck.setLoanRemainPrincipal(jsonObject.get(File11Head.loanRemainPrincipal).getAsBigDecimal());
        projectCheck.setExtractDate(DateUtils.string2Date(jsonObject.get(File11Head.extractDate).getAsString()));
        return projectCheck;
    }

}
