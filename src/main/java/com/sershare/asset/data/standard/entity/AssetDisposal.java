package com.sershare.asset.data.standard.entity;

import java.util.Date;

public class AssetDisposal {
    private Integer id;

    private String projectId;

    private String agencyId;

    private String assetId;

    private String disposiStatus;

    private String disposiType;

    private String litigateNode;

    private String litigateNodeTime;

    private String disposiEsult;

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

    public String getDisposiStatus() {
        return disposiStatus;
    }

    public void setDisposiStatus(String disposiStatus) {
        this.disposiStatus = disposiStatus;
    }

    public String getDisposiType() {
        return disposiType;
    }

    public void setDisposiType(String disposiType) {
        this.disposiType = disposiType;
    }

    public String getLitigateNode() {
        return litigateNode;
    }

    public void setLitigateNode(String litigateNode) {
        this.litigateNode = litigateNode;
    }

    public void setDisposiEsult(String disposiEsult) {
        this.disposiEsult = disposiEsult;
    }

    public String getLitigateNodeTime() {
        return litigateNodeTime;
    }

    public void setLitigateNodeTime(String litigateNodeTime) {
        this.litigateNodeTime = litigateNodeTime == null ? null : litigateNodeTime.trim();
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

    public String getDisposiEsult() {
        return disposiEsult;
    }
}