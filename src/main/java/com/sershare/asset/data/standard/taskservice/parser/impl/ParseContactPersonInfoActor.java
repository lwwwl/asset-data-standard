package com.sershare.asset.data.standard.taskservice.parser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.common.SysConstant;
import com.sershare.asset.data.standard.config.AssetAccessConfig;
import com.sershare.asset.data.standard.entity.ContactPersonInfo;
import com.sershare.asset.data.standard.explain.File02Head;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.utils.DocumentUtil;
import com.sershare.asset.data.standard.utils.GsonUtils;
import com.sershare.asset.data.standard.wsmq.util.AesPlus;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("ParseContactPersonInfoActor")
public class ParseContactPersonInfoActor implements IFileParseActuator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AssetAccessConfig assetAccessConfig;

    @Override
    public JsonObject run(JsonElement jsonElement) {
        logger.info("开始执行文件解析");
        if (Objects.isNull(jsonElement)) {
            logger.info("参数错误！");
            return null;
        }
        ContactPersonInfo contactPersonInfo = parseContactPersionInfo(jsonElement);
        return GsonUtils.objectToJsonTree(contactPersonInfo).getAsJsonObject();
    }

    private ContactPersonInfo parseContactPersionInfo(JsonElement jsonElement){
        ContactPersonInfo contactPersonInfo = new ContactPersonInfo();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        contactPersonInfo.setProjectId(jsonObject.get(File02Head.projectId) == null ? null : jsonObject.get(File02Head.projectId).getAsString());
        contactPersonInfo.setAgencyId(jsonObject.get(File02Head.agencyId) == null ? null : jsonObject.get(File02Head.agencyId).getAsString());
        contactPersonInfo.setAssetId(jsonObject.get(File02Head.assetId) == null ? null : jsonObject.get(File02Head.assetId).getAsString());
        contactPersonInfo.setCustomerName(jsonObject.get(File02Head.customerName) == null ? null : jsonObject.get(File02Head.customerName).getAsString());
        contactPersonInfo.setPhoneNum(jsonObject.get(File02Head.phoneNum) == null ? null : jsonObject.get(File02Head.phoneNum).getAsString());
        String documentNum = jsonObject.get(File02Head.documentNum) == null ? null : jsonObject.get(File02Head.documentNum).getAsString();
        contactPersonInfo.setDocumentNum(documentNum);
        if (StringUtils.isBlank(documentNum)) {
            String age = jsonObject.get(File02Head.age) == null ? null : jsonObject.get(File02Head.age).getAsString();
            contactPersonInfo.setAge(StringUtils.isBlank(age)?0:Integer.valueOf(age));
            contactPersonInfo.setSex(jsonObject.get(File02Head.sex) == null ? null : jsonObject.get(File02Head.sex).getAsString());
        } else {
            String secret = assetAccessConfig.getCodekey() + SysConstant.SECRET_KEY;
            documentNum = AesPlus.starlinkDecrypt(secret,documentNum);
            String certificateType = jsonObject.get(File02Head.certificateType) == null ? null : jsonObject.get(File02Head.certificateType).getAsString();
            if(StringUtils.isNotBlank(certificateType) && File02Head.idType.equals(jsonObject.get(File02Head.certificateType).getAsString())){
                contactPersonInfo.setAge(DocumentUtil.getAgeByIdNo(documentNum));
                contactPersonInfo.setSex(DocumentUtil.getSexByIdNo(documentNum));
            }
        }
        contactPersonInfo.setMainborrowerRelationship(jsonObject.get(File02Head.mainborrowerRelationship) == null ? null : jsonObject.get(File02Head.mainborrowerRelationship).getAsString());
        contactPersonInfo.setOccupation(jsonObject.get(File02Head.occupation) == null ? null : jsonObject.get(File02Head.occupation).getAsString());
        contactPersonInfo.setWorkStatus(jsonObject.get(File02Head.workStatus) == null ? null : jsonObject.get(File02Head.workStatus).getAsString());
        contactPersonInfo.setAnnualIncome(jsonObject.get(File02Head.annualIncome) == null ? null : jsonObject.get(File02Head.annualIncome).getAsBigDecimal());
        contactPersonInfo.setCommunicationAddress(jsonObject.get(File02Head.communicationAddress) == null ? null : jsonObject.get(File02Head.communicationAddress).getAsString());
        contactPersonInfo.setUnitAddress(jsonObject.get(File02Head.unitAddress) == null ? null : jsonObject.get(File02Head.unitAddress).getAsString());
        contactPersonInfo.setUnitPhoneNumber(jsonObject.get(File02Head.unitPhoneNumber) == null ? null : jsonObject.get(File02Head.unitPhoneNumber).getAsString());
        return contactPersonInfo;
    }

}
