package com.sershare.asset.data.standard.explain;

import java.util.Date;

/**
 * @program: asset-status
 * @description:
 * @author: xiongwei.zhu
 * @create: 2018-12-04 16:25
 **/
public class AbsTaskParams {

    private String projectId;
    private String assetId;
    private String agencyId;
    private Date date;
    private String absFileType;

    private Object data;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getAbsFileType() {
        return absFileType;
    }

    public void setAbsFileType(String absFileType) {
        this.absFileType = absFileType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
