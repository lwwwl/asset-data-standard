package com.sershare.asset.data.standard.entity;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;

public class AssetSupplement {
    private Integer id;
    @SerializedName(value = "项目编号", alternate = {"projectId"})
    private String projectId;

    @SerializedName(value = "机构编号", alternate = {"agencyId"})
    private String agencyId;

    @SerializedName(value = "借据号", alternate = {"assetId"})
    private String assetId;
    @SerializedName(value = "交易类型", alternate = {"tradetype"})
    private String tradetype;
    @SerializedName(value = "交易原因", alternate = {"tradereason"})
    private String tradereason;
    @SerializedName(value = "交易日期", alternate = {"tradedate"})
    private String tradedate;
    @SerializedName(value = "交易总金额", alternate = {"tradeTolAmounts"})
    private BigDecimal tradeTolAmounts;
    @SerializedName(value = "本金", alternate = {"principal"})
    private BigDecimal principal;
    @SerializedName(value = "利息", alternate = {"interest"})
    private BigDecimal interest;
    @SerializedName(value = "罚息", alternate = {"punishInterest"})
    private BigDecimal punishInterest;
    @SerializedName(value = "其他费用", alternate = {"othFee"})
    private BigDecimal othFee;

    private Date createTime;

    private Date updateTime;

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

    public String getTradetype() {
        return tradetype;
    }

    public void setTradetype(String tradetype) {
        this.tradetype = tradetype;
    }

    public String getTradereason() {
        return tradereason;
    }

    public void setTradereason(String tradereason) {
        this.tradereason = tradereason == null ? null : tradereason.trim();
    }

    public String getTradedate() {
        return tradedate;
    }

    public void setTradedate(String tradedate) {
        this.tradedate = tradedate == null ? null : tradedate.trim();
    }

    public BigDecimal getTradeTolAmounts() {
        return tradeTolAmounts;
    }

    public void setTradeTolAmounts(BigDecimal tradeTolAmounts) {
        this.tradeTolAmounts = tradeTolAmounts;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getPunishInterest() {
        return punishInterest;
    }

    public void setPunishInterest(BigDecimal punishInterest) {
        this.punishInterest = punishInterest;
    }

    public BigDecimal getOthFee() {
        return othFee;
    }

    public void setOthFee(BigDecimal othFee) {
        this.othFee = othFee;
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