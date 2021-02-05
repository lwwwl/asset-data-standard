package com.sershare.asset.data.standard.entity;

import java.util.Date;

public class EnterpriseInfo {
    private Integer id;

    private String projectId;

    private String agencyId;

    private String assetId;

    private String contractRole;

    private String enterpriseName;

    private String businessNumber;

    private String organizateCode;

    private String taxpayerNumber;

    private String unifiedCreditCode;

    private String registeredAddress;

    private String loanType;

    private String industry;

    private String legalPersonName;

    private String idType;

    private String idNo;

    private String legalPersonPhone;

    private String phone;

    private int operateYears;

    private String isLinked;

    private String province;


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

    public String getContractRole() {
        return contractRole;
    }

    public void setContractRole(String contractRole) {
        this.contractRole = contractRole;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber == null ? null : businessNumber.trim();
    }

    public String getOrganizateCode() {
        return organizateCode;
    }

    public void setOrganizateCode(String organizateCode) {
        this.organizateCode = organizateCode == null ? null : organizateCode.trim();
    }

    public String getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(String taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber == null ? null : taxpayerNumber.trim();
    }

    public String getUnifiedCreditCode() {
        return unifiedCreditCode;
    }

    public void setUnifiedCreditCode(String unifiedCreditCode) {
        this.unifiedCreditCode = unifiedCreditCode == null ? null : unifiedCreditCode.trim();
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress == null ? null : registeredAddress.trim();
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

    public String getLoanType() {
        return loanType;
    }

    public EnterpriseInfo setLoanType(String loanType) {
        this.loanType = loanType;
        return this;
    }

    public String getIndustry() {
        return industry;
    }

    public EnterpriseInfo setIndustry(String industry) {
        this.industry = industry;
        return this;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public EnterpriseInfo setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
        return this;
    }

    public String getIdType() {
        return idType;
    }

    public EnterpriseInfo setIdType(String idType) {
        this.idType = idType;
        return this;
    }

    public String getIdNo() {
        return idNo;
    }

    public EnterpriseInfo setIdNo(String idNo) {
        this.idNo = idNo;
        return this;
    }

    public String getLegalPersonPhone() {
        return legalPersonPhone;
    }

    public EnterpriseInfo setLegalPersonPhone(String legalPersonPhone) {
        this.legalPersonPhone = legalPersonPhone;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public EnterpriseInfo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public int getOperateYears() {
        return operateYears;
    }

    public EnterpriseInfo setOperateYears(int operateYears) {
        this.operateYears = operateYears;
        return this;
    }

    public String getIsLinked() {
        return isLinked;
    }

    public EnterpriseInfo setIsLinked(String isLinked) {
        this.isLinked = isLinked;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public EnterpriseInfo setProvince(String province) {
        this.province = province;
        return this;
    }
}