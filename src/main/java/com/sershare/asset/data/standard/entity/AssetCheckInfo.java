package com.sershare.asset.data.standard.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AssetCheckInfo {

    private Integer id;

    private String projectId;

    private String agencyId;

    private String assetId;

    private Integer repayedperiod;

    private Integer remainPeriod;

    private BigDecimal remainPrincipal;

    private BigDecimal remainInterest;

    private BigDecimal remainOthamounts;

    private String nextPayDate;

    private String assetsStatus;

    private String settleReason;

    private BigDecimal currentOverduePrincipal;

    private BigDecimal currentOverdueInterest;

    private BigDecimal currentOverdueFee;

    private Integer currentOverdueDays;

    private Integer accumOverdueDays;

    private Integer hisAccumOverdueDays;

    private Integer hisOverdueMdays;

    private Integer currentOverduePeriod;

    private Integer accumOverduePeriod;

    private Integer hisOverdueMperiods;

    private BigDecimal hisOverdueMprincipal;

    private String extraInfo;

    private String remark;

    private Date createTime;

    private Date updateTime;

    /** 数据提取日 2018-12-26 17:12 新增 by wangpeng*/
    private Date extractDate;

    public Date getExtractDate() {
        return extractDate;
    }

    public void setExtractDate(Date extractDate) {
        this.extractDate = extractDate;
    }

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

    public String getNextPayDate() {
        return nextPayDate;
    }

    public void setNextPayDate(String nextPayDate) {
        this.nextPayDate = nextPayDate == null ? null : nextPayDate.trim();
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
}
