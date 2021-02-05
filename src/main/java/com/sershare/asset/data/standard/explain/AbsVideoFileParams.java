package com.sershare.asset.data.standard.explain;

/**
 * @program: asset-status
 * @description: 推送ABS影像文件任务参数
 * @author: xiongwei.zhu
 * @create: 2019-04-25 17:54
 **/
public class AbsVideoFileParams {

    private String projectId;

    private String agencyId;

    private String assetId;

    private String videoPath;

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

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}
