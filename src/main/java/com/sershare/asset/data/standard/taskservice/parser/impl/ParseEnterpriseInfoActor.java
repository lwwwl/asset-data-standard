package com.sershare.asset.data.standard.taskservice.parser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.common.SysConstant;
import com.sershare.asset.data.standard.config.AssetAccessConfig;
import com.sershare.asset.data.standard.entity.EnterpriseInfo;
import com.sershare.asset.data.standard.explain.File12Head;
import com.sershare.asset.data.standard.explain.FileShareHead;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.utils.GsonUtils;
import com.sershare.asset.data.standard.wsmq.util.AesPlus;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component("ParseEnterpriseInfoActor")
public class ParseEnterpriseInfoActor implements IFileParseActuator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    AssetAccessConfig assetAccessConfig;

    @Override
    public JsonObject run(JsonElement jsonElement) {
        logger.info("开始执行文件解析");
        if (Objects.isNull(jsonElement)) {
            logger.info("参数错误！");
            return null;
        }
        EnterpriseInfo enterpriseInfo = parseEnterpriseInfo(jsonElement);
        return GsonUtils.objectToJsonTree(enterpriseInfo).getAsJsonObject();
    }

    private EnterpriseInfo parseEnterpriseInfo(JsonElement jsonElement) {
        String secret = assetAccessConfig.getCodekey() + SysConstant.SECRET_KEY;
        EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        enterpriseInfo.setAgencyId(jsonObject.get(FileShareHead.agencyId) == null ? null : jsonObject.get(FileShareHead.agencyId).getAsString());
        enterpriseInfo.setAssetId(jsonObject.get(FileShareHead.assetId) == null ? null : jsonObject.get(FileShareHead.assetId).getAsString());
        enterpriseInfo.setProjectId(jsonObject.get(FileShareHead.projectId) == null ? null : jsonObject.get(FileShareHead.projectId).getAsString());
        enterpriseInfo.setContractRole(jsonObject.get(File12Head.CONTRACTROLE) == null ? null : jsonObject.get(File12Head.CONTRACTROLE).getAsString());
        enterpriseInfo.setEnterpriseName(jsonObject.get(File12Head.COMPANYNAME) == null ? null : jsonObject.get(File12Head.COMPANYNAME).getAsString());
        enterpriseInfo.setOrganizateCode(jsonObject.get(File12Head.ORGANIZATIONCODE) == null ? null : jsonObject.get(File12Head.ORGANIZATIONCODE).getAsString());
        enterpriseInfo.setTaxpayerNumber(jsonObject.get(File12Head.TAXPAYMENTNUMBER) == null ? null : jsonObject.get(File12Head.TAXPAYMENTNUMBER).getAsString());
        enterpriseInfo.setBusinessNumber(jsonObject.get(File12Head.INDUSTRIALNUMBERKEY) == null ? null : jsonObject.get(File12Head.INDUSTRIALNUMBERKEY).getAsString());
        enterpriseInfo.setRegisteredAddress(jsonObject.get(File12Head.REGISTERADDRESS) == null ? null : jsonObject.get(File12Head.REGISTERADDRESS).getAsString());
        enterpriseInfo.setUnifiedCreditCode(jsonObject.get(File12Head.UNIFIEDCREDITCODEKEY) == null ? null : jsonObject.get(File12Head.UNIFIEDCREDITCODEKEY).getAsString());
        enterpriseInfo.setLoanType(jsonObject.get(File12Head.LOANTYPE) == null ? null : jsonObject.get(File12Head.LOANTYPE).getAsString());
        enterpriseInfo.setIndustry(jsonObject.get(File12Head.INDUSTRY) == null ? null : jsonObject.get(File12Head.INDUSTRY).getAsString());
        String legalPersonName = jsonObject.get(File12Head.LEGALPERSONNAME) == null ? "" : jsonObject.get(File12Head.LEGALPERSONNAME).getAsString();
        legalPersonName = AesPlus.starlinkEncrypt(secret,legalPersonName);
        enterpriseInfo.setLegalPersonName(legalPersonName);
        enterpriseInfo.setIdType(jsonObject.get(File12Head.LEGALPERSONIDTYPE) == null ? null : jsonObject.get(File12Head.LEGALPERSONIDTYPE).getAsString());
        String idNo = jsonObject.get(File12Head.LEGALPERSONIDNO) == null ? "" : jsonObject.get(File12Head.LEGALPERSONIDNO).getAsString();
        idNo = AesPlus.starlinkEncrypt(secret,idNo);
        enterpriseInfo.setIdNo(idNo);
        String legalPersonPhone = jsonObject.get(File12Head.LEGALPERSONPHONE) == null ? "" : jsonObject.get(File12Head.LEGALPERSONPHONE).getAsString();
        legalPersonPhone = AesPlus.starlinkEncrypt(secret,legalPersonPhone);
        enterpriseInfo.setLegalPersonPhone(legalPersonPhone);
        enterpriseInfo.setPhone(jsonObject.get(File12Head.PHONE) == null ? null : jsonObject.get(File12Head.PHONE).getAsString());
        String operate = jsonObject.get(File12Head.OPERATEYEARS) == null ? null : jsonObject.get(File12Head.OPERATEYEARS).getAsString();
        enterpriseInfo.setOperateYears(StringUtils.isBlank(operate)? 0 : Integer.valueOf(operate));
        enterpriseInfo.setIsLinked(jsonObject.get(File12Head.LINKED) == null ? null : jsonObject.get(File12Head.LINKED).getAsString());
        enterpriseInfo.setProvince(jsonObject.get(File12Head.PROVINCE) == null ? null : jsonObject.get(File12Head.PROVINCE).getAsString());

        return enterpriseInfo;
    }

}
