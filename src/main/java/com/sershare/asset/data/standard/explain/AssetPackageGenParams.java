package com.sershare.asset.data.standard.explain;

/**
 * @program: asset-status
 * @description: 文件生成
 * @author: xiongwei.zhu
 * @create: 2019-03-11 15:56
 **/
public class AssetPackageGenParams {

    /**项目编号*/
    private String projectId;
    /**机构编号*/
    private String agencyId;
    /**发送系统*/
    private String system;
    /**发送文件*/
    private String fileType;

    private String assetId;

    private String statusDate;

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

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }
}
