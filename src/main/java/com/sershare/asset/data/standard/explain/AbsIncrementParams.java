package com.sershare.asset.data.standard.explain;

import java.util.Date;

/**
 * @program: asset-status
 * @description:
 * @author: xiongwei.zhu
 * @create: 2019-05-10 11:26
 **/
public class AbsIncrementParams {
    /**
     * 项目Id
     */
    private String projectId;
    /**
     * 机构Id
     */
    private String agencyId;
    /**
     * 数据日期
     */
    private String date;

    private Date assectCheckDate;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getAssectCheckDate() {
        return assectCheckDate;
    }

    public void setAssectCheckDate(Date assectCheckDate) {
        this.assectCheckDate = assectCheckDate;
    }
}
