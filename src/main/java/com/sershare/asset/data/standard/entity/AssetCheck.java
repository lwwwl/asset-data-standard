package com.sershare.asset.data.standard.entity;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;

public class AssetCheck {
    private Integer id;
    @SerializedName(value = "项目编号",alternate = "projectId")
    private String projectId;
    @SerializedName(value = "机构编号",alternate = "agencyId")
    private String agencyId;
    @SerializedName(value = "借据号",alternate = "assetId")
    private String assetId;
    @SerializedName(value = "是否变更还款计划",alternate = "changeRepayPlan")
    private String changeRepayPlan;
    @SerializedName(value = "变更时间",alternate = "changeDate")
    private String changeDate;
    @SerializedName(value = "贷款总金额(元)",alternate = "loanTotalAmount")
    private BigDecimal loanTotalAmount;
    @SerializedName(value = "贷款年利率(%)",alternate = "loanInterestRate")
    private BigDecimal loanInterestRate;
    @SerializedName(value = "总期数",alternate = "periods")
    private Integer periods;
    @SerializedName(value = "当天实还总金额",alternate = "recoveredTotalAmount")
    private BigDecimal recoveredTotalAmount;
    @SerializedName(value = "当天实还本金(元)",alternate = "relPrincipal")
    private BigDecimal relPrincipal;
    @SerializedName(value = "当天实还利息(元)",alternate = "relInterest")
    private BigDecimal relInterest;
    @SerializedName(value = "当天实还费用(元)",alternate = "relFee")
    private BigDecimal relFee;
    @SerializedName(value = "数据提取日",alternate = "accountDate")
    private Date accountDate;
    @SerializedName(value = "已还期数",alternate = "repayedperiod")
    private Integer repayedperiod = 0;
    @SerializedName(value = "剩余期数",alternate = "remainPeriod")
    private Integer remainPeriod = 0;
    @SerializedName(value = "剩余本金(元)",alternate = "remainPrincipal")
    private BigDecimal remainPrincipal = BigDecimal.ZERO;
    @SerializedName(value = "剩余利息(元)",alternate = "remainInterest")
    private BigDecimal remainInterest = BigDecimal.ZERO;
    @SerializedName(value = "剩余其他费用(元)",alternate = "remainOthamounts")
    private BigDecimal remainOthamounts = BigDecimal.ZERO;
    @SerializedName(value = "下一期应还款日",alternate = "nextPayDate")
    private Date nextPayDate;
    @SerializedName(value = "资产状态",alternate = "assetsStatus")
    private String assetsStatus;
    @SerializedName(value = "结清原因",alternate = "settleReason")
    private String settleReason;
    @SerializedName(value = "当前逾期本金",alternate = "currentOverduePrincipal")
    private BigDecimal currentOverduePrincipal = BigDecimal.ZERO;
    @SerializedName(value = "当前逾期利息",alternate = "currentOverdueInterest")
    private BigDecimal currentOverdueInterest = BigDecimal.ZERO;
    @SerializedName(value = "当前逾期费用",alternate = "currentOverdueFee")
    private BigDecimal currentOverdueFee = BigDecimal.ZERO;
    @SerializedName(value = "当前逾期天数(天)",alternate = "currentOverdueDays")
    private Integer currentOverdueDays = 0;
    @SerializedName(value = "累计逾期天数",alternate = "accumOverdueDays")
    private Integer accumOverdueDays = 0;
    @SerializedName(value = "历史累计逾期天数",alternate = "hisAccumOverdueDays")
    private Integer hisAccumOverdueDays = 0;
    @SerializedName(value = "历史单次最长逾期天数(天)",alternate = "hisOverdueMdays")
    private Integer hisOverdueMdays = 0;
    @SerializedName(value = "当前逾期期数",alternate = "currentOverduePeriod")
    private Integer currentOverduePeriod = 0;
    @SerializedName(value = "累计逾期期数",alternate = "accumOverduePeriod")
    private Integer accumOverduePeriod =0;
    @SerializedName(value = "历史单次最长逾期期数",alternate = "hisOverdueMperiods")
    private Integer hisOverdueMperiods = 0;
    @SerializedName(value = "历史最大逾期本金",alternate = "hisOverdueMprincipal")
    private BigDecimal hisOverdueMprincipal = BigDecimal.ZERO;
    @SerializedName(value = "当前连续逾期天数",alternate = "currentContinuityOverdays")
    private Integer currentContinuityOverdays = 0;
    @SerializedName(value = "最长单期逾期天数",alternate = "maxSingleOverduedays")
    private Integer maxSingleOverduedays = 0;
    @SerializedName(value = "最长连续逾期天数",alternate = "maxContinuityOverdays")
    private Integer maxContinuityOverdays = 0;
    @SerializedName(value = "结清日期",alternate = "loanSettlementDate")
    private Date loanSettlementDate;
    @SerializedName(value = "损失本金",alternate = "lossPrincipal")
    private BigDecimal lossPrincipal = BigDecimal.ZERO;
    @SerializedName(value = "剩余罚息(元)",alternate = "remainPenalty")
    private BigDecimal remainPenalty;
    @SerializedName(value = "累计实还金额(元)",alternate = "totalRelAmount")
    private BigDecimal totalRelAmount;
    @SerializedName(value = "累计实还本金(元)",alternate = "totalRelPrincipal")
    private BigDecimal totalRelPrincipal;
    @SerializedName(value = "累计实还利息(元)",alternate = "totalRelInterest")
    private BigDecimal totalRelInterest;
    @SerializedName(value = "累计实还费用(元)",alternate = "totalRelFee")
    private BigDecimal totalRelFee;
    @SerializedName(value = "累计实还罚息(元)",alternate = "totalRelPenalty")
    private BigDecimal totalRelPenalty;
    @SerializedName(value = "当天实还罚息(元)",alternate = "relPenalty")
    private BigDecimal relPenalty;
    @SerializedName(value = "当前期次",alternate = "currPeriod")
    private Integer currPeriod;
    @SerializedName(value = "首期是否逾期",alternate = "firstTermOverdue")
    private String firstTermOverdue;

    private String extraInfo;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private String partnerCode;

    private String productCode;

    private String billNo;

    private String contractNo;

    private Date loanDate;

    private BigDecimal loanAmount;

    private Integer loanTerm;

    private String billStatus;

    private BigDecimal currentRemainPrincipal;

    private BigDecimal currentRepaidPrincipal;

    private String shouldRepayMonth;

    private String shouldRepayDate;

    private BigDecimal shouldRepayPrincipal;

    private Integer currentOverdueTerm;

    private String currentOverdueStage;

    private Integer accumulateOverdueDays;

    private Integer accumulateOverdueNum;

    private BigDecimal accumOverduePrincipal;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getChangeRepayPlan() {
        return changeRepayPlan;
    }

    public void setChangeRepayPlan(String changeRepayPlan) {
        this.changeRepayPlan = changeRepayPlan;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    public BigDecimal getLoanTotalAmount() {
        return loanTotalAmount;
    }

    public void setLoanTotalAmount(BigDecimal loanTotalAmount) {
        this.loanTotalAmount = loanTotalAmount;
    }

    public BigDecimal getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(BigDecimal loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate ;
    }

    public Integer getRepayedperiod() {
        return repayedperiod;
    }

    public void setRepayedperiod(Integer repayedperiod) {
        this.repayedperiod = repayedperiod;
    }

    public Integer getRemainPeriod() {
        return remainPeriod;
    }

    public void setRemainPeriod(Integer remainPeriod) {
        this.remainPeriod = remainPeriod;
    }

    public BigDecimal getRemainPrincipal() {
        return remainPrincipal;
    }

    public void setRemainPrincipal(BigDecimal remainPrincipal) {
        this.remainPrincipal = remainPrincipal;
    }

    public BigDecimal getRemainInterest() {
        return remainInterest;
    }

    public void setRemainInterest(BigDecimal remainInterest) {
        this.remainInterest = remainInterest;
    }

    public BigDecimal getRemainOthamounts() {
        return remainOthamounts;
    }

    public void setRemainOthamounts(BigDecimal remainOthamounts) {
        this.remainOthamounts = remainOthamounts;
    }

    public Date getNextPayDate() {
        return nextPayDate;
    }

    public void setNextPayDate(Date nextPayDate) {
        this.nextPayDate = nextPayDate;
    }

    public String getAssetsStatus() {
        return assetsStatus;
    }

    public void setAssetsStatus(String assetsStatus) {
        this.assetsStatus = assetsStatus;
    }

    public String getSettleReason() {
        return settleReason;
    }

    public void setSettleReason(String settleReason) {
        this.settleReason = settleReason;
    }

    public BigDecimal getCurrentOverduePrincipal() {
        return currentOverduePrincipal;
    }

    public void setCurrentOverduePrincipal(BigDecimal currentOverduePrincipal) {
        this.currentOverduePrincipal = currentOverduePrincipal;
    }

    public BigDecimal getCurrentOverdueInterest() {
        return currentOverdueInterest;
    }

    public void setCurrentOverdueInterest(BigDecimal currentOverdueInterest) {
        this.currentOverdueInterest = currentOverdueInterest;
    }

    public BigDecimal getCurrentOverdueFee() {
        return currentOverdueFee;
    }

    public void setCurrentOverdueFee(BigDecimal currentOverdueFee) {
        this.currentOverdueFee = currentOverdueFee;
    }

    public Integer getCurrentOverdueDays() {
        return currentOverdueDays;
    }

    public void setCurrentOverdueDays(Integer currentOverdueDays) {
        this.currentOverdueDays = currentOverdueDays;
    }

    public Integer getAccumOverdueDays() {
        return accumOverdueDays;
    }

    public void setAccumOverdueDays(Integer accumOverdueDays) {
        this.accumOverdueDays = accumOverdueDays;
    }

    public Integer getHisAccumOverdueDays() {
        return hisAccumOverdueDays;
    }

    public void setHisAccumOverdueDays(Integer hisAccumOverdueDays) {
        this.hisAccumOverdueDays = hisAccumOverdueDays;
    }

    public Integer getHisOverdueMdays() {
        return hisOverdueMdays;
    }

    public void setHisOverdueMdays(Integer hisOverdueMdays) {
        this.hisOverdueMdays = hisOverdueMdays;
    }

    public Integer getCurrentOverduePeriod() {
        return currentOverduePeriod;
    }

    public void setCurrentOverduePeriod(Integer currentOverduePeriod) {
        this.currentOverduePeriod = currentOverduePeriod;
    }

    public Integer getAccumOverduePeriod() {
        return accumOverduePeriod;
    }

    public void setAccumOverduePeriod(Integer accumOverduePeriod) {
        this.accumOverduePeriod = accumOverduePeriod;
    }

    public Integer getHisOverdueMperiods() {
        return hisOverdueMperiods;
    }

    public void setHisOverdueMperiods(Integer hisOverdueMperiods) {
        this.hisOverdueMperiods = hisOverdueMperiods;
    }

    public BigDecimal getHisOverdueMprincipal() {
        return hisOverdueMprincipal;
    }

    public void setHisOverdueMprincipal(BigDecimal hisOverdueMprincipal) {
        this.hisOverdueMprincipal = hisOverdueMprincipal;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo == null ? null : extraInfo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public BigDecimal getRecoveredTotalAmount() {
        return recoveredTotalAmount;
    }

    public void setRecoveredTotalAmount(BigDecimal recoveredTotalAmount) {
        this.recoveredTotalAmount = recoveredTotalAmount;
    }


    public BigDecimal getRelPrincipal() {
        return relPrincipal;
    }

    public void setRelPrincipal(BigDecimal relPrincipal) {
        this.relPrincipal = relPrincipal;
    }

    public BigDecimal getRelInterest() {
        return relInterest;
    }

    public void setRelInterest(BigDecimal relInterest) {
        this.relInterest = relInterest;
    }

    public BigDecimal getRelFee() {
        return relFee;
    }

    public void setRelFee(BigDecimal relFee) {
        this.relFee = relFee;
    }

    public Integer getCurrentContinuityOverdays() {
        return currentContinuityOverdays;
    }

    public void setCurrentContinuityOverdays(Integer currentContinuityOverdays) {
        this.currentContinuityOverdays = currentContinuityOverdays;
    }

    public Integer getMaxSingleOverduedays() {
        return maxSingleOverduedays;
    }

    public void setMaxSingleOverduedays(Integer maxSingleOverduedays) {
        this.maxSingleOverduedays = maxSingleOverduedays;
    }

    public Integer getMaxContinuityOverdays() {
        return maxContinuityOverdays;
    }

    public void setMaxContinuityOverdays(Integer maxContinuityOverdays) {
        this.maxContinuityOverdays = maxContinuityOverdays;
    }

    public Date getLoanSettlementDate() {
        return loanSettlementDate;
    }

    public void setLoanSettlementDate(Date loanSettlementDate) {
        this.loanSettlementDate = loanSettlementDate;
    }

    public BigDecimal getLossPrincipal() {
        return lossPrincipal;
    }

    public void setLossPrincipal(BigDecimal lossPrincipal) {
        this.lossPrincipal = lossPrincipal;
    }

    public BigDecimal getRemainPenalty() {
        return remainPenalty;
    }

    public void setRemainPenalty(BigDecimal remainPenalty) {
        this.remainPenalty = remainPenalty;
    }

    public BigDecimal getTotalRelAmount() {
        return totalRelAmount;
    }

    public void setTotalRelAmount(BigDecimal totalRelAmount) {
        this.totalRelAmount = totalRelAmount;
    }

    public BigDecimal getTotalRelPrincipal() {
        return totalRelPrincipal;
    }

    public void setTotalRelPrincipal(BigDecimal totalRelPrincipal) {
        this.totalRelPrincipal = totalRelPrincipal;
    }

    public BigDecimal getTotalRelInterest() {
        return totalRelInterest;
    }

    public void setTotalRelInterest(BigDecimal totalRelInterest) {
        this.totalRelInterest = totalRelInterest;
    }

    public BigDecimal getTotalRelFee() {
        return totalRelFee;
    }

    public void setTotalRelFee(BigDecimal totalRelFee) {
        this.totalRelFee = totalRelFee;
    }

    public BigDecimal getTotalRelPenalty() {
        return totalRelPenalty;
    }

    public void setTotalRelPenalty(BigDecimal totalRelPenalty) {
        this.totalRelPenalty = totalRelPenalty;
    }

    public BigDecimal getRelPenalty() {
        return relPenalty;
    }

    public void setRelPenalty(BigDecimal relPenalty) {
        this.relPenalty = relPenalty;
    }

    public Integer getCurrPeriod() {
        return currPeriod;
    }

    public void setCurrPeriod(Integer currPeriod) {
        this.currPeriod = currPeriod;
    }

    public String getFirstTermOverdue() {
        return firstTermOverdue;
    }

    public void setFirstTermOverdue(String firstTermOverdue) {
        this.firstTermOverdue = firstTermOverdue;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(Integer loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public BigDecimal getCurrentRemainPrincipal() {
        return currentRemainPrincipal;
    }

    public void setCurrentRemainPrincipal(BigDecimal currentRemainPrincipal) {
        this.currentRemainPrincipal = currentRemainPrincipal;
    }

    public BigDecimal getCurrentRepaidPrincipal() {
        return currentRepaidPrincipal;
    }

    public void setCurrentRepaidPrincipal(BigDecimal currentRepaidPrincipal) {
        this.currentRepaidPrincipal = currentRepaidPrincipal;
    }

    public String getShouldRepayMonth() {
        return shouldRepayMonth;
    }

    public void setShouldRepayMonth(String shouldRepayMonth) {
        this.shouldRepayMonth = shouldRepayMonth;
    }

    public String getShouldRepayDate() {
        return shouldRepayDate;
    }

    public void setShouldRepayDate(String shouldRepayDate) {
        this.shouldRepayDate = shouldRepayDate;
    }

    public BigDecimal getShouldRepayPrincipal() {
        return shouldRepayPrincipal;
    }

    public void setShouldRepayPrincipal(BigDecimal shouldRepayPrincipal) {
        this.shouldRepayPrincipal = shouldRepayPrincipal;
    }

    public Integer getCurrentOverdueTerm() {
        return currentOverdueTerm;
    }

    public void setCurrentOverdueTerm(Integer currentOverdueTerm) {
        this.currentOverdueTerm = currentOverdueTerm;
    }

    public String getCurrentOverdueStage() {
        return currentOverdueStage;
    }

    public void setCurrentOverdueStage(String currentOverdueStage) {
        this.currentOverdueStage = currentOverdueStage;
    }

    public Integer getAccumulateOverdueDays() {
        return accumulateOverdueDays;
    }

    public void setAccumulateOverdueDays(Integer accumulateOverdueDays) {
        this.accumulateOverdueDays = accumulateOverdueDays;
    }

    public Integer getAccumulateOverdueNum() {
        return accumulateOverdueNum;
    }

    public void setAccumulateOverdueNum(Integer accumulateOverdueNum) {
        this.accumulateOverdueNum = accumulateOverdueNum;
    }

    public BigDecimal getAccumOverduePrincipal() {
        return accumOverduePrincipal;
    }

    public void setAccumOverduePrincipal(BigDecimal accumOverduePrincipal) {
        this.accumOverduePrincipal = accumOverduePrincipal;
    }
}