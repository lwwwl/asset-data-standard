package com.sershare.asset.data.standard.model;

import java.io.Serializable;

/**
 * @program: AssertStatusProject
 * @description: 资产查询参数
 * @author: xiongwei.zhu
 * @create: 2018-11-19 16:00
 **/
public class AssetQueryBean extends BaseObject implements Serializable {


    private static final long serialVersionUID = 7123449536073350223L;
    /**借据号*/
    private String assetId;
    /**项目号*/
    private String projectId;
    /**机构号*/
    private String agencyId;
    /**贷款合同编号*/
    private String contractCode;

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
}
