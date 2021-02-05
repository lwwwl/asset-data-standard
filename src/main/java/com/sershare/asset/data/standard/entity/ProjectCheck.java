package com.sershare.asset.data.standard.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ProjectCheck {
    private Integer id;

    private String projectId;

    private String agencyId;

    private Integer loanSums;

    private BigDecimal loanRemainPrincipal;

    private BigDecimal loanContractTolAmounts;

    private String extraInfo;

    private Date createTime;

    private Date updateTime;

    private Date extractDate;

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

    public Integer getLoanSums() {
        return loanSums;
    }

    public void setLoanSums(Integer loanSums) {
        this.loanSums = loanSums;
    }

    public BigDecimal getLoanRemainPrincipal() {
        return loanRemainPrincipal;
    }

    public void setLoanRemainPrincipal(BigDecimal loanRemainPrincipal) {
        this.loanRemainPrincipal = loanRemainPrincipal;
    }

    public BigDecimal getLoanContractTolAmounts() {
        return loanContractTolAmounts;
    }

    public void setLoanContractTolAmounts(BigDecimal loanContractTolAmounts) {
        this.loanContractTolAmounts = loanContractTolAmounts;
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

    public Date getExtractDate() {
        return extractDate;
    }

    public void setExtractDate(Date extractDate) {
        this.extractDate = extractDate;
    }
}