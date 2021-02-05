package com.sershare.asset.data.standard.wsmq.wsmq;

import com.sershare.asset.data.standard.wsmq.util.StringZipUtils;

public class MqMessage implements java.io.Serializable{
    private MqHeader mqHeader;
    private String zipBody;

    public MqHeader getMqHeader() {
        return mqHeader;
    }

    public void setMqHeader(MqHeader mqHeader) {
        this.mqHeader = mqHeader;
    }

    public String getZipBody() {
        return zipBody;
    }

    public void setZipBody(String zipBody) {
        this.zipBody = zipBody;
    }

    public String getUnZipBody() {
        return StringZipUtils.unzip(zipBody);
    }

    public void setUnZipBody(String unZipBody) {
        this.zipBody = StringZipUtils.zip(unZipBody);
    }
}
