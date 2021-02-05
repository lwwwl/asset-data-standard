package com.sershare.asset.data.standard.entity;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
    private static final long serialVersionUID = 966724108504063205L;
    private Integer id;

    private String projectId;

    private String projectName;

    private String projectType;

    private String chainId;

    private String nodeId;

    private String appendUrl;

    private String queryUrl;

    private String txUrl;

    private String privateKey;

    private String mchId;

    private String version;

    private Integer currentReadHeight;

    private Integer maxHeight;

    private Date createTime;

    private Date modifyTime;

    private String blockSign;

    private String agencyId;
    /**行为控制*/
    private String actionData;
    /**计算控制*/
    private String calculateData;
    /**项目封包日*/
    private Date packetDate;

    private int timeDifference;

    private int checkDifference;

    private Date videoHandleStartdate;

    private Date videoHandleEnddate;

    private String videoFilePath;

    private int graceDays = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId == null ? null : chainId.trim();
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    public String getAppendUrl() {
        return appendUrl;
    }

    public void setAppendUrl(String appendUrl) {
        this.appendUrl = appendUrl == null ? null : appendUrl.trim();
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl == null ? null : queryUrl.trim();
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey == null ? null : privateKey.trim();
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getCurrentReadHeight() {
        return currentReadHeight;
    }

    public void setCurrentReadHeight(Integer currentReadHeight) {
        this.currentReadHeight = currentReadHeight;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getBlockSign() {
        return blockSign;
    }

    public void setBlockSign(String blockSign) {
        this.blockSign = blockSign == null ? null : blockSign.trim();
    }

    public String getTxUrl() {
        return txUrl;
    }

    public void setTxUrl(String txUrl) {
        this.txUrl = txUrl;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getActionData() {
        return actionData;
    }

    public void setActionData(String actionData) {
        this.actionData = actionData;
    }

    public String getCalculateData() {
        return calculateData;
    }

    public void setCalculateData(String calculateData) {
        this.calculateData = calculateData;
    }

    public Date getPacketDate() {
        return packetDate;
    }

    public void setPacketDate(Date packetDate) {
        this.packetDate = packetDate;
    }

    public int getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(int timeDifference) {
        this.timeDifference = timeDifference;
    }

    public int getCheckDifference() {
        return checkDifference;
    }

    public void setCheckDifference(int checkDifference) {
        this.checkDifference = checkDifference;
    }

    public Date getVideoHandleStartdate() {
        return videoHandleStartdate;
    }

    public void setVideoHandleStartdate(Date videoHandleStartdate) {
        this.videoHandleStartdate = videoHandleStartdate;
    }

    public Date getVideoHandleEnddate() {
        return videoHandleEnddate;
    }

    public void setVideoHandleEnddate(Date videoHandleEnddate) {
        this.videoHandleEnddate = videoHandleEnddate;
    }

    public String getVideoFilePath() {
        return videoFilePath;
    }

    public void setVideoFilePath(String videoFilePath) {
        this.videoFilePath = videoFilePath;
    }

    public int getGraceDays() {
        return graceDays;
    }

    public void setGraceDays(int graceDays) {
        this.graceDays = graceDays;
    }
}