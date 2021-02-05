package com.sershare.asset.data.standard.explain;

public class AssertAccessTaskBeanParams {
    /**项目编号*/
    private String projectId;
    /**机构编号*/
    private String agencyId;
    /**批次号*/
    private String importId;
    /**全局时间戳**/
    private String timestamp;

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

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
