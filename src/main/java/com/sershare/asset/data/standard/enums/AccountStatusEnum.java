package com.sershare.asset.data.standard.enums;

/**
 * @program: asset-status
 * @description: 账户状态
 * @author: xiongwei.zhu
 * @create: 2018-12-20 16:36
 **/
public enum AccountStatusEnum {
    NORMAL("正常", "ZHENGCHANG"),
    OVERDUE("逾期", "YUQI"),
    PAYOFF("提前还清", "ZAOCHANG"),
    ;

    String desc;

    String code;

    AccountStatusEnum(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
