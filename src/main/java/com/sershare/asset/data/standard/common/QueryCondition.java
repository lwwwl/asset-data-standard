package com.sershare.asset.data.standard.common;

import java.io.Serializable;

/**
 * @author v_wangpeng
 * @date 2018/11/6 19:27
 */
public class QueryCondition implements Serializable {

    private static final long serialVersionUID = 7123449536073350223L;
    /**借据号*/
    private String assetId;
    /**项目号*/
    private String projectId;
    /**机构号*/
    private String agencyId;
    /**贷款合同编号*/
    private String contractCode;
    /**排序方式*/
    private String orderBy;
    /**批次号*/
    private String importId;
    /**任务编号*/
    private String id;
    /**任务状态*/
    private String status;

    private String taskClassName;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getTaskClassName() {
        return taskClassName;
    }

    public void setTaskClassName(String taskClassName) {
        this.taskClassName = taskClassName;
    }
}
