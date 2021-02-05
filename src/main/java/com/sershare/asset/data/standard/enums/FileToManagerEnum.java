package com.sershare.asset.data.standard.enums;

/**
 * @Description: 文件类型 -> manager类映射枚举
 * @author: i_laowei
 * @date: 2021/1/28  17:32
 */

public enum FileToManagerEnum {

    FILE01("LoanContractManager"),
    FILE02("PrincipalBorrowerInfoManager"),
    FILE03("ContactPersonInfoManager"),
    FILE04("GuarantyInfoManager"),
    FILE05("RepaymentScheduleManager"),
    FILE06("AssetFlowInfoManager"),
    FILE07("RepaymentInfoSecManager"),
    FILE08("AssetDisposalManager"),
    FILE09("AssetSupplementManager"),
    FILE10("AssetCheckInfoManager"),
    FILE11("ProjectCheckManager"),
    FILE12("EnterpriseInfoManager"),
    FILE13("GuarantyInfo");

    private String managerName;

    FileToManagerEnum(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
