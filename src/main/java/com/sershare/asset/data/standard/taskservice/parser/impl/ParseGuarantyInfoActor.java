package com.sershare.asset.data.standard.taskservice.parser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.entity.GuarantyInfo;
import com.sershare.asset.data.standard.entity.Project;
import com.sershare.asset.data.standard.explain.File04Head;
import com.sershare.asset.data.standard.explain.FileShareHead;
import com.sershare.asset.data.standard.mapper.ProjectMapper;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/1  14:26
 */

@Component("ParseGuarantyInfo")
public class ParseGuarantyInfoActor implements IFileParseActuator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    ProjectMapper projectMapper;

    @Override
    public JsonObject run(JsonElement jsonElement) {
        logger.info("开始执行文件解析");
        if (Objects.isNull(jsonElement)) {
            logger.info("参数错误！");
            return null;
        }
        Project project = projectMapper.findProjectId(jsonElement.getAsJsonObject().get(FileShareHead.projectId).getAsString());
        GuarantyInfo guarantyInfo = parseGuarantyInfo(jsonElement, project);
        return GsonUtils.objectToJsonTree(guarantyInfo).getAsJsonObject();
    }

    private GuarantyInfo parseGuarantyInfo(JsonElement jsonElement, Project project) {
        GuarantyInfo guarantyInfo = new GuarantyInfo();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        guarantyInfo.setExtraInfo(jsonElement.toString());
        guarantyInfo.setProjectId(jsonObject.get(FileShareHead.projectId) == null ? null : jsonObject.get(FileShareHead.projectId).getAsString());
        guarantyInfo.setAgencyId(jsonObject.get(FileShareHead.agencyId) == null ? null : jsonObject.get(FileShareHead.agencyId).getAsString());
        guarantyInfo.setAssetId(jsonObject.get(FileShareHead.assetId) == null ? null : jsonObject.get(FileShareHead.assetId).getAsString());
        guarantyInfo.setGuarantyType(project.getProjectType());
        guarantyInfo.setGuarantyUmber(jsonObject.get(File04Head.guarantyUmber) == null ? UUID.randomUUID().toString() : jsonObject.get(File04Head.guarantyUmber).getAsString());
        guarantyInfo.setMortgageAlignment(jsonObject.get(File04Head.mortgageAlignment) == null ? null : jsonObject.get(File04Head.mortgageAlignment).getAsString());
        guarantyInfo.setMortgageHandleStatus(jsonObject.get(File04Head.mortgageHandleStatus) == null ? null : jsonObject.get(File04Head.mortgageHandleStatus).getAsString());
        return guarantyInfo;
    }

}
