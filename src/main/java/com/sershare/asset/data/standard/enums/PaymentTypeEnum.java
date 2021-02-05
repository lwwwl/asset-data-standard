package com.sershare.asset.data.standard.enums;

public enum PaymentTypeEnum {

    PREPAYMENT("提前还款"),
    NORMALPAYMENT("正常还款"),
    PARTIALREPAYMENT("部分还款"),
    OVERDUEPAYMENT("逾期还款");

    String type;

    PaymentTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
