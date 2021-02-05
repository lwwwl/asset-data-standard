package com.sershare.asset.data.standard.taskservice.parser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.common.SysConstant;
import com.sershare.asset.data.standard.entity.LoanContractInfo;
import com.sershare.asset.data.standard.enums.AssetVerifyStatusEnum;
import com.sershare.asset.data.standard.explain.File01Head;
import com.sershare.asset.data.standard.taskservice.parser.IFileParseActuator;
import com.sershare.asset.data.standard.utils.DateUtils;
import com.sershare.asset.data.standard.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Component("ParseLoanContractActor")
public class ParseLoanContractActor implements IFileParseActuator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public JsonObject run(JsonElement jsonElement) {
        logger.info("开始执行文件解析");
        if (Objects.isNull(jsonElement)) {
            logger.error("参数错误！");
            return null;
        }
        LoanContractInfo loanContractInfo = parseLoanContractInfo(jsonElement);
        return GsonUtils.objectToJsonTree(loanContractInfo).getAsJsonObject();
    }


    private LoanContractInfo parseLoanContractInfo(JsonElement jsonElement) {
        LoanContractInfo loanContractInfo = new LoanContractInfo();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        loanContractInfo.setExtraInfo(jsonElement.toString());
        loanContractInfo.setImportId(jsonObject.get(File01Head.importId) == null ? null : jsonObject.get(File01Head.importId).getAsString());
        loanContractInfo.setProjectId(jsonObject.get(File01Head.projectId) == null ? null : jsonObject.get(File01Head.projectId).getAsString());
        loanContractInfo.setAssetId(jsonObject.get(File01Head.assetId) == null ? null : jsonObject.get(File01Head.assetId).getAsString());
        loanContractInfo.setAgencyId(jsonObject.get(File01Head.agencyId) == null ? null : jsonObject.get(File01Head.agencyId).getAsString());
        loanContractInfo.setContractCode(jsonObject.get(File01Head.contractCode) == null ? null : jsonObject.get(File01Head.contractCode).getAsString());
        loanContractInfo.setPeriods(jsonObject.get(File01Head.periods) == null ? null : jsonObject.get(File01Head.periods).getAsInt());
        loanContractInfo.setRepayType(jsonObject.get(File01Head.repayType) == null ? null : jsonObject.get(File01Head.repayType).getAsString());
        loanContractInfo.setInterestRateType(jsonObject.get(File01Head.interestRateType) == null ? null : jsonObject.get(File01Head.interestRateType).getAsString());
        loanContractInfo.setLoanInterestRate(jsonObject.get(File01Head.loanYearInterestRate) == null ? null : jsonObject.get(File01Head.loanYearInterestRate).getAsString());
        loanContractInfo.setContractStatus(jsonObject.get(File01Head.contractStatus) == null ? null : jsonObject.get(File01Head.contractStatus).getAsString());
        loanContractInfo.setFirstRepayDate(jsonObject.get(File01Head.firstRepayDate) == null ? null : jsonObject.get(File01Head.firstRepayDate).getAsString());
        loanContractInfo.setLoanTotalAmount(jsonObject.get(File01Head.loanTotalAmount) == null ? null : jsonObject.get(File01Head.loanTotalAmount).getAsBigDecimal());
        loanContractInfo.setContractStatus(jsonObject.get(File01Head.contractStatus) == null ? null : jsonObject.get(File01Head.contractStatus).getAsString());
        loanContractInfo.setGuaranteeType(jsonObject.get(File01Head.guaranteeType) == null ? null : jsonObject.get(File01Head.guaranteeType).getAsString());
        loanContractInfo.setRepayFrequency(jsonObject.get(File01Head.frequency) == null ? null : jsonObject.get(File01Head.frequency).getAsString());
        loanContractInfo.setFirstLoanEndDate(DateUtils.string2Date(jsonObject.get(File01Head.endDate) == null ? null : jsonObject.get(File01Head.endDate).getAsString()));
        loanContractInfo.setCurLoanEndDate(DateUtils.string2Date(jsonObject.get(File01Head.endDate) == null ? null : jsonObject.get(File01Head.endDate).getAsString()));
        loanContractInfo.setPerLoanEndDate(DateUtils.string2Date(jsonObject.get(File01Head.endDate) == null ? null : jsonObject.get(File01Head.endDate).getAsString()));
        loanContractInfo.setLoanBeginDate(DateUtils.string2Date(jsonObject.get(File01Head.startDate) == null ? null : jsonObject.get(File01Head.startDate).getAsString()));
        loanContractInfo.setAbsPushFlag(SysConstant.NO_PUSH);
        loanContractInfo.setVerifyStatus(AssetVerifyStatusEnum.NORMAL.getDesc());
        loanContractInfo.setLoanTotalInterest(checkIsBlank(jsonObject.get(File01Head.loanTotalInterest)));
        loanContractInfo.setLoanTotalFee(checkIsBlank(jsonObject.get(File01Head.loanTotalFee)));
        loanContractInfo.setLoanPenaltyRate(checkIsBlank(jsonObject.get(File01Head.loanPenaltyRate)));
        loanContractInfo.setLoanType(!jsonObject.has(File01Head.loanType) ? "个人": jsonObject.get(File01Head.loanType).getAsString());
        return loanContractInfo;
    }

    public BigDecimal checkIsBlank(JsonElement jsonElement) {
        if(Objects.isNull(jsonElement) || jsonElement.getAsString().equals("")) {
            return BigDecimal.ZERO;
        }
        return jsonElement.getAsBigDecimal();
    }

}
