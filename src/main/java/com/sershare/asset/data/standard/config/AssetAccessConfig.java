package com.sershare.asset.data.standard.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "asset-access")
public class AssetAccessConfig {
    private String savezippath;
    private String codekey;
    private String temppath;
    private String businesstype;
    private String logpath;
    private String saveftppath;
    private String savepackagepath;
    private String idCardCodeKey;

    public String getSavezippath() {
        return savezippath;
    }

    public void setSavezippath(String savezippath) {
        this.savezippath = savezippath;
    }

    public String getCodekey() {
        return codekey;
    }

    public void setCodekey(String codekey) {
        this.codekey = codekey;
    }

    public String getTemppath() {
        return temppath;
    }

    public void setTemppath(String temppath) {
        this.temppath = temppath;
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public String getLogpath() {
        return logpath;
    }

    public void setLogpath(String logpath) {
        this.logpath = logpath;
    }

    public String getSaveftppath() {
        return saveftppath;
    }

    public void setSaveftppath(String saveftppath) {
        this.saveftppath = saveftppath;
    }

    public String getSavepackagepath() {
        return savepackagepath;
    }

    public void setSavepackagepath(String savepackagepath) {
        this.savepackagepath = savepackagepath;
    }

    public String getIdCardCodeKey() {
        return idCardCodeKey;
    }

    public void setIdCardCodeKey(String idCardCodeKey) {
        this.idCardCodeKey = idCardCodeKey;
    }
}

