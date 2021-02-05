package com.sershare.asset.data.standard.rocketmq.model;

import java.util.Date;

public class MqHeader {
    private String root;
    private String pre;
    private String current;
    private String system;
    private String timestamp;

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
