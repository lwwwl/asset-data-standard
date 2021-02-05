package com.sershare.asset.data.standard.taskservice.parser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.common.SysConstant;
import com.sershare.asset.data.standard.config.AssetAccessConfig;
import com.sershare.asset.data.standard.entity.PrincipalBorrowerInfo;
import com.sershare.asset.data.standard.explain.File02Head;
import com.sershare.asset.data.standard.explain.FileShareHead;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.utils.DocumentUtil;
import com.sershare.asset.data.standard.utils.GsonUtils;
import com.sershare.asset.data.standard.wsmq.util.AesPlus;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Objects;

@Component("ParsePrincipalBorrowerInfoActor")
public class ParsePrincipalBorrowerInfoActor implements IFileParseActuator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    AssetAccessConfig assetAccessConfig;

    @Override
    public JsonObject run(JsonElement jsonElement) {
        logger.info("开始执行文件解析");
        if (Objects.isNull(jsonElement)) {
            logger.error("参数错误！");
            return null;
        }
        PrincipalBorrowerInfo principalBorrowerInfo = parsePrincipalBorrowerInfo(jsonElement);
        return GsonUtils.objectToJsonTree(principalBorrowerInfo).getAsJsonObject();
    }

    private PrincipalBorrowerInfo parsePrincipalBorrowerInfo(JsonElement jsonElement) {
        PrincipalBorrowerInfo principalBorrowerInfo = new PrincipalBorrowerInfo();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        principalBorrowerInfo.setExtraInfo(jsonElement.toString());
        principalBorrowerInfo.setProjectId(jsonObject.get(FileShareHead.projectId) == null ? null : jsonObject.get(FileShareHead.projectId).getAsString());
        principalBorrowerInfo.setAgencyId(jsonObject.get(FileShareHead.agencyId) == null ? null : jsonObject.get(FileShareHead.agencyId).getAsString());
        principalBorrowerInfo.setAssetId(jsonObject.get(FileShareHead.assetId) == null ? null : jsonObject.get(FileShareHead.assetId).getAsString());

        principalBorrowerInfo.setCustomerName(jsonObject.get(File02Head.customerName) == null ? null : jsonObject.get(File02Head.customerName).getAsString());
        principalBorrowerInfo.setPhoneNum(jsonObject.get(File02Head.phoneNum) == null ? null : jsonObject.get(File02Head.phoneNum).getAsString());
        String documentNum = jsonObject.get(File02Head.documentNum) == null ? null : jsonObject.get(File02Head.documentNum).getAsString();
        principalBorrowerInfo.setDocumentNum(jsonObject.get(File02Head.documentNum) == null ? null : jsonObject.get(File02Head.documentNum).getAsString());
        if (StringUtils.isBlank(documentNum)) {
            String age = jsonObject.get(File02Head.age) == null ? null : jsonObject.get(File02Head.age).getAsString();
            principalBorrowerInfo.setAge(StringUtils.isBlank(age)?0:Integer.valueOf(age));
            principalBorrowerInfo.setSex(jsonObject.get(File02Head.sex) == null ? null : jsonObject.get(File02Head.sex).getAsString());
        } else {
            String secret = assetAccessConfig.getCodekey() + SysConstant.SECRET_KEY;
            documentNum = AesPlus.starlinkDecrypt(secret,documentNum);
            String certificateType = jsonObject.get(File02Head.certificateType) == null ? null : jsonObject.get(File02Head.certificateType).getAsString();
            if(StringUtils.isNotBlank(certificateType) && File02Head.idType.equals(jsonObject.get(File02Head.certificateType).getAsString())){
                principalBorrowerInfo.setAge(DocumentUtil.getAgeByIdNo(documentNum));
                principalBorrowerInfo.setSex(DocumentUtil.getSexByIdNo(documentNum));
            }
        }
        principalBorrowerInfo.setMaritalStatus(jsonObject.get(File02Head.maritalStatus) == null ? null : jsonObject.get(File02Head.maritalStatus).getAsString());
        principalBorrowerInfo.setDegree(jsonObject.get(File02Head.degree) == null ? null : jsonObject.get(File02Head.degree).getAsString());
        principalBorrowerInfo.setProvince(jsonObject.get(File02Head.province) == null ? null : jsonObject.get(File02Head.province).getAsString());
        principalBorrowerInfo.setCity(jsonObject.get(File02Head.city) == null ? null : jsonObject.get(File02Head.city).getAsString());
        principalBorrowerInfo.setAddress(jsonObject.get(File02Head.address) == null ? null : jsonObject.get(File02Head.address).getAsString());
        JsonElement educationJson = jsonObject.get(File02Head.education);
        String education = Objects.nonNull(educationJson) ? educationJson.getAsString() : "";
        principalBorrowerInfo.setEducation(education);
        principalBorrowerInfo.setAnnualIncome(checkIsBlank(jsonObject.get(File02Head.annualIncome)));

        return principalBorrowerInfo;
    }

    public BigDecimal checkIsBlank(JsonElement jsonElement) {
        if(Objects.isNull(jsonElement) || jsonElement.getAsString().equals("")) {
            return BigDecimal.ZERO;
        }
        return jsonElement.getAsBigDecimal();
    }

}
