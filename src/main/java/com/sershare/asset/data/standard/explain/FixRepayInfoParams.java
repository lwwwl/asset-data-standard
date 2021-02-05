package com.sershare.asset.data.standard.explain;

import java.util.Date;

/**
 * @program: asset-status
 * @description: 修正实还信息任务参数
 * @author: xiongwei.zhu
 * @create: 2018-12-11 16:29
 **/
public class FixRepayInfoParams {

    private String projectId;

    private String assetId;

    private String agencyId;

    private int period;

    private Date date;

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

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
