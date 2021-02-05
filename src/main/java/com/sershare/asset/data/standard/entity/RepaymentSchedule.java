package com.sershare.asset.data.standard.entity;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;

public class RepaymentSchedule {
    private Integer id;

    private String importId;
    @SerializedName(value = "项目编号", alternate = {"projectId"})
    private String projectId;
    @SerializedName(value = "机构编号", alternate = {"agencyId"})
    private String agencyId;
    @SerializedName(value = "借据号", alternate = {"assetId"})
    private String assetId;
    @SerializedName(value = "期次", alternate = {"period"})
    private Integer period;
    @SerializedName(value = "应还款日", alternate = {"repayDate"})
    private Date repayDate;
    @SerializedName(value = "应还本金(元)", alternate = {"repayPrincipal"})
    private BigDecimal repayPrincipal;
    @SerializedName(value = "应还利息(元)", alternate = {"repayInterest"})
    private BigDecimal repayInterest;
    @SerializedName(value = "应还费用(元)", alternate = {"repayFee"})
    private BigDecimal repayFee;
    @SerializedName(value = "应还罚息(元)", alternate = {"repayPenalty"})
    private BigDecimal repayPenalty;
    @SerializedName(value = "生效日期", alternate = {"executeDate"})
    private Date executeDate;

    private Date timestamp;

    private String extraInfo;

    private Date createTime;

    private Date updateTime;

    // 增加计算辅助字段，这些字段将在插入数据库的时候初始化，帮助实还信息计算
    // 期初剩余本金
    private BigDecimal beginLoanPrincipal;

    // 期末剩余本金
    private BigDecimal endLoanPrincipal;

    // 期初剩余利息
    private BigDecimal beginLoanInterest;

    // 期末剩余利息
    private BigDecimal endLoanInterest;

    // 期初剩余费用
    private BigDecimal beginLoanFee;

    // 期末剩余费用
    private BigDecimal endLoanFee;

    // 期末剩余期数
    private int remainderPeriods;

    // 下一个还款日
    private Date nextRepayDate;

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

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public BigDecimal getRepayPrincipal() {
        return repayPrincipal;
    }

    public void setRepayPrincipal(BigDecimal repayPrincipal) {
        this.repayPrincipal = repayPrincipal;
    }

    public BigDecimal getRepayInterest() {
        return repayInterest;
    }

    public void setRepayInterest(BigDecimal repayInterest) {
        this.repayInterest = repayInterest;
    }

    public BigDecimal getRepayFee() {
        return repayFee;
    }

    public void setRepayFee(BigDecimal repayFee) {
        this.repayFee = repayFee;
    }

    public BigDecimal getRepayPenalty() {
        return repayPenalty;
    }

    public void setRepayPenalty(BigDecimal repayPenalty) {
        this.repayPenalty = repayPenalty;
    }

    public Date getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(Date executeDate) {
        this.executeDate = executeDate;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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

    public BigDecimal getBeginLoanPrincipal() {
        return beginLoanPrincipal;
    }

    public void setBeginLoanPrincipal(BigDecimal beginLoanPrincipal) {
        this.beginLoanPrincipal = beginLoanPrincipal;
    }

    public BigDecimal getEndLoanPrincipal() {
        return endLoanPrincipal;
    }

    public void setEndLoanPrincipal(BigDecimal endLoanPrincipal) {
        this.endLoanPrincipal = endLoanPrincipal;
    }

    public BigDecimal getBeginLoanInterest() {
        return beginLoanInterest;
    }

    public void setBeginLoanInterest(BigDecimal beginLoanInterest) {
        this.beginLoanInterest = beginLoanInterest;
    }

    public BigDecimal getEndLoanInterest() {
        return endLoanInterest;
    }

    public void setEndLoanInterest(BigDecimal endLoanInterest) {
        this.endLoanInterest = endLoanInterest;
    }

    public int getRemainderPeriods() {
        return remainderPeriods;
    }

    public void setRemainderPeriods(int remainderPeriods) {
        this.remainderPeriods = remainderPeriods;
    }

    public BigDecimal getBeginLoanFee() {
        return beginLoanFee;
    }

    public void setBeginLoanFee(BigDecimal beginLoanFee) {
        this.beginLoanFee = beginLoanFee;
    }

    public BigDecimal getEndLoanFee() {
        return endLoanFee;
    }

    public void setEndLoanFee(BigDecimal endLoanFee) {
        this.endLoanFee = endLoanFee;
    }

    public Date getNextRepayDate() {
        return nextRepayDate;
    }

    public void setNextRepayDate(Date nextRepayDate) {
        this.nextRepayDate = nextRepayDate;
    }
}