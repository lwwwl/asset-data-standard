package com.sershare.asset.data.standard.entity;

import java.util.Date;

public class GuarantyInfo {
    private Integer id;

    private String projectId;

    private String agencyId;

    private String assetId;

    private String guarantyType;

    private String guarantyUmber;

    private String mortgageHandleStatus;

    private String mortgageAlignment;

    private String extraInfo;

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

    public String getGuarantyType() {
        return guarantyType;
    }

    public void setGuarantyType(String guarantyType) {
        this.guarantyType = guarantyType;
    }

    public String getGuarantyUmber() {
        return guarantyUmber;
    }

    public void setGuarantyUmber(String guarantyUmber) {
        this.guarantyUmber = guarantyUmber == null ? null : guarantyUmber.trim();
    }

    public String getMortgageHandleStatus() {
        return mortgageHandleStatus;
    }

    public void setMortgageHandleStatus(String mortgageHandleStatus) {
        this.mortgageHandleStatus = mortgageHandleStatus;
    }

    public String getMortgageAlignment() {
        return mortgageAlignment;
    }

    public void setMortgageAlignment(String mortgageAlignment) {
        this.mortgageAlignment = mortgageAlignment;
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
}