package com.sershare.asset.data.standard.entity.sftp;

public class SftpInfo {

    /**
     * ip
     */
    private String ip;

    /**
     * 端口
     */
    private int port;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 目录
     */
    private String inputDir;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInputDir() {
        return inputDir;
    }

    public void setInputDir(String inputDir) {
        this.inputDir = inputDir;
    }
}
