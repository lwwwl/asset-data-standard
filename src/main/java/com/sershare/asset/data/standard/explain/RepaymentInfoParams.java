package com.sershare.asset.data.standard.explain;

/**
 * @program: AssertStatusProject
 * @description: 实还计算任务参数
 * @author: xiongwei.zhu
 * @create: 2018-11-26 14:54
 **/
public class RepaymentInfoParams {

    private String assetId;

    private int period;

    private String projectId;

    public RepaymentInfoParams() {
    }

    public RepaymentInfoParams(String assetId, int period, String projectId) {
        this.assetId = assetId;
        this.period = period;
        this.projectId = projectId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
