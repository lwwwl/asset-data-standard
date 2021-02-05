package com.sershare.asset.data.standard.enums;

/**
 * @Description: 文件类型映射
 * @author: i_laowei
 * @date: 2021/2/3  15:22
 */
public enum  FileTypeEnum {

    ASSET_CHECK_INFO("10");

    String fileCode;

    FileTypeEnum(String fileCode) {
        this.fileCode = fileCode;
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }
}
