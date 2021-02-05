package com.sershare.asset.data.standard.enums;

/**
 * 资产校验状态枚举
 */
public enum AssetVerifyStatusEnum {

    NORMAL("正常"),
    NOPLANPREPAYMENT("无还款计划提前还清"),
    PREPAYMENT("提前还清"),
    PARTIALREPAYMENT("部分还款"),
    REPAYMENTLESSTHANREPAYAMOUNT("实还本金小于应还本金"),
    REPAYMENTLINFOMARKMANYSCHEDULE("应还信息对应多条还款信息"),
    BASEDATAERROR("基础数据错误"),

    REPAYMENTSCHEDULESLOSS("还款计划缺失"),
    REPAYMENTINFOLOSS("实还信息缺失"),
    FIXEND("已修正数据"),
    FIXED_ALGORITHM_ERROR("修复算法失败"),
    ;



    private String desc;




    AssetVerifyStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
