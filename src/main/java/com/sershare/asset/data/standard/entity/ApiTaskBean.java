package com.sershare.asset.data.standard.entity;

import java.util.Date;

public class ApiTaskBean {

    private Integer id;

    private Integer parentTaskId;

    private String status;

    private String host;

    private String desc;

    private String taskClassName;

    private String params;

    private String errorMsg;

    private Date createTime;

    private Date modifyTime;

    private String groupBatch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(Integer parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getTaskClassName() {
        return taskClassName;
    }

    public void setTaskClassName(String taskClassName) {
        this.taskClassName = taskClassName == null ? null : taskClassName.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
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

    public String getGroupBatch() {
        return groupBatch;
    }

    public void setGroupBatch(String groupBatch) {
        this.groupBatch = groupBatch;
    }

}
