package com.sershare.asset.data.standard.entity;

import java.math.BigDecimal;
import java.util.Date;

public class LoanContractInfo {
    private Integer id;

    private String importId;

    private String projectId;

    private String agencyId;

    private String assetId;

    private String contractCode;

    private BigDecimal loanTotalAmount;

    private Integer periods;

    private String repayType;

    private String interestRateType;

    private String loanInterestRate;

    private Integer contractDataStatus;

    private String contractStatus;

    private String firstRepayDate;

    private String extraInfo;

    private Date createTime;

    private Date updateTime;

    private String verifyStatus;

    private String verifyMark;

    private Date firstLoanEndDate;

    private Date perLoanEndDate;

    private Date curLoanEndDate;

    private Date loanBeginDate;

    private String absPushFlag;

    private BigDecimal loanTotalInterest;

    private BigDecimal loanTotalFee;

    private BigDecimal loanPenaltyRate;


    private String repayFrequency;

    private BigDecimal nominalRate;

    private BigDecimal dailyPenaltyRate;

    private String loanUse;

    private String guaranteeType;

    private String loanType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId == null ? null : importId.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId == null ? null : agencyId.trim();
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId == null ? null : assetId.trim();
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    public BigDecimal getLoanTotalAmount() {
        return loanTotalAmount;
    }

    public void setLoanTotalAmount(BigDecimal loanTotalAmount) {
        this.loanTotalAmount = loanTotalAmount;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType == null ? null : repayType.trim();
    }

    public String getInterestRateType() {
        return interestRateType;
    }

    public void setInterestRateType(String interestRateType) {
        this.interestRateType = interestRateType == null ? null : interestRateType.trim();
    }

    public String getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(String loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public Integer getContractDataStatus() {
        return contractDataStatus;
    }

    public void setContractDataStatus(Integer contractDataStatus) {
        this.contractDataStatus = contractDataStatus;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus == null ? null : contractStatus.trim();
    }

    public String getFirstRepayDate() {
        return firstRepayDate;
    }

    public void setFirstRepayDate(String firstRepayDate) {
        this.firstRepayDate = firstRepayDate == null ? null : firstRepayDate.trim();
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo == null ? null : extraInfo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus == null ? null : verifyStatus.trim();
    }

    public String getVerifyMark() {
        return verifyMark;
    }

    public void setVerifyMark(String verifyMark) {
        this.verifyMark = verifyMark == null ? null : verifyMark.trim();
    }

    public Date getFirstLoanEndDate() {
        return firstLoanEndDate;
    }

    public void setFirstLoanEndDate(Date firstLoanEndDate) {
        this.firstLoanEndDate = firstLoanEndDate;
    }

    public Date getPerLoanEndDate() {
        return perLoanEndDate;
    }

    public void setPerLoanEndDate(Date perLoanEndDate) {
        this.perLoanEndDate = perLoanEndDate;
    }

    public Date getCurLoanEndDate() {
        return curLoanEndDate;
    }

    public void setCurLoanEndDate(Date curLoanEndDate) {
        this.curLoanEndDate = curLoanEndDate;
    }

    public Date getLoanBeginDate() {
        return loanBeginDate;
    }

    public void setLoanBeginDate(Date loanBeginDate) {
        this.loanBeginDate = loanBeginDate;
    }

    public String getAbsPushFlag() {
        return absPushFlag;
    }

    public void setAbsPushFlag(String absPushFlag) {
        this.absPushFlag = absPushFlag;
    }

    public BigDecimal getLoanTotalInterest() {
        return loanTotalInterest;
    }

    public void setLoanTotalInterest(BigDecimal loanTotalInterest) {
        this.loanTotalInterest = loanTotalInterest;
    }

    public BigDecimal getLoanTotalFee() {
        return loanTotalFee;
    }

    public void setLoanTotalFee(BigDecimal loanTotalFee) {
        this.loanTotalFee = loanTotalFee;
    }

    public BigDecimal getLoanPenaltyRate() {
        return loanPenaltyRate;
    }

    public void setLoanPenaltyRate(BigDecimal loanPenaltyRate) {
        this.loanPenaltyRate = loanPenaltyRate;
    }

    public String getRepayFrequency() {
        return repayFrequency;
    }

    public void setRepayFrequency(String repayFrequency) {
        this.repayFrequency = repayFrequency;
    }

    public BigDecimal getNominalRate() {
        return nominalRate;
    }

    public void setNominalRate(BigDecimal nominalRate) {
        this.nominalRate = nominalRate;
    }

    public BigDecimal getDailyPenaltyRate() {
        return dailyPenaltyRate;
    }

    public void setDailyPenaltyRate(BigDecimal dailyPenaltyRate) {
        this.dailyPenaltyRate = dailyPenaltyRate;
    }

    public String getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse;
    }

    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
}