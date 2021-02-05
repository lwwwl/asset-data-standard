package com.sershare.asset.data.standard.enums;

/**
 * @Auther: xiaomudong
 * @Date: 2018/7/17 14:30
 * @Description: 生成abs文件类型对应关系
 */
public enum AbsFileTypeEnum {

    NEWASSET("入池资产信息文件","01"),

    NEWINSTALLMENT("初始还款计划文件","02"),

    FUNDS("资产交易支付信息文件","03"),

    INSTALLMENT("还款计划信息文件","04"),


    //todo abs暂时处理file05 && 不上传给abs
    SCENE("合同变更信息文件","05"),

    ASSET("资产状态信息文件","06"),

    REPURCHASE("资产回购信息文件","08"),

    COBORROWER("关联人信息文件","09"),
    ;


    private String type;
    private String fileNameNum;
    AbsFileTypeEnum(String type, String fileNameNum){
        this.type = type;
        this.fileNameNum = fileNameNum;
    }
    public String getType() {
        return type;
    }

    public String getFileNameNum() {
        return fileNameNum;
    }

    public static AbsFileTypeEnum geAbsFileTypeEnumByName(String name){
        for(AbsFileTypeEnum em : AbsFileTypeEnum.values()){
            if(em.name().equalsIgnoreCase(name)){
                return em;
            }
        }
        return null;
    }

    public static AbsFileTypeEnum geAbsFileTypeByName(String fileNameNum){
        for(AbsFileTypeEnum em : AbsFileTypeEnum.values()){
            if(em.getFileNameNum().equalsIgnoreCase(fileNameNum)){
                return em;
            }
        }
        return null;
    }

}
