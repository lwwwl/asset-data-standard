package com.sershare.asset.data.standard.explain;

public class File02Head extends FileShareHead {
    public static String customerName = "客户姓名";
    public static String documentNum = "身份证号";
    public static String phoneNum = "手机号";
    public static String age = "年龄";
    public static String sex = "性别";
    public static String maritalStatus = "婚姻状况";
    public static String degree = "学历";
    public static String education = "学位";
    public static String province = "客户居住所在省";
    public static String city = "客户居住所在市";
    public static String address = "客户居住地址";
    public static String mainborrowerRelationship = "与主借款人关系";
    public static String occupation = "职业";
    public static String workStatus = "工作状态";
    public static String annualIncome = "年收入(元)";
    public static String communicationAddress = "通讯地址";
    public static String unitAddress = "单位地址";
    public static String unitPhoneNumber = "单位联系方式";
    public static String certificateType = "证件类型";
    public static String idType = "身份证";

    public static String private_owners = "是否私营业主";// 枚举 N Y("是") N("否") Null("未知")

    public static String income_m1 = "盒伙人1个月累计佣金";// BigDecimal(10,2) N

    public static String income_m3 = "盒伙人3个月累计佣金";// BigDecimal(10,2) N

    public static String income_m6 = "盒伙人6个月累计佣金";// BigDecimal(10,2) N

    public static String income_m12 = "盒伙人12个月累计佣金";//
    /**
     * 账户类型
     */
    public static String accountType = "account_type";
    /**
     * 银行卡号
     */
    public static String accountNum = "account_num";
    /**
     * 银行名称
     */
    public static String bankName = "bank_name";
    /**
     * 开户支行
     */
    public static String branchName = "branch_name";
    /**
     * 银行预留手机号
     */
    public static String mobilePhone = "mobile_phone";

    public static String frontUrl = "front_url";

    public static String backUrl = "back_url";
}
