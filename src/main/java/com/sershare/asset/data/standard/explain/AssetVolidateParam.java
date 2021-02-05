package com.sershare.asset.data.standard.explain;

import java.util.Date;

/**
 * @program: asset-status
 * @description:
 * @author: xiongwei.zhu
 * @create: 2019-05-21 17:12
 **/
public class AssetVolidateParam {

    private String projectId;

    private String agencyId;

    private String assetId;

    private Date volidateDate;

    private Date checkDate;


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

    public Date getVolidateDate() {
        return volidateDate;
    }

    public void setVolidateDate(Date volidateDate) {
        this.volidateDate = volidateDate;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }
}
