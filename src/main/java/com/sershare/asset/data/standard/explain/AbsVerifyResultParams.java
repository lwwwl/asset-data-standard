package com.sershare.asset.data.standard.explain;

/**
 * @program: asset-status
 * @description:
 * @author: xiongwei.zhu
 * @create: 2018-12-19 14:46
 **/
public class AbsVerifyResultParams {

    private String projectId;

    private String agencyId;

    private String assetId;

    private String zipName;


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

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getZipName() {
        return zipName;
    }

    public void setZipName(String zipName) {
        this.zipName = zipName;
    }
}
