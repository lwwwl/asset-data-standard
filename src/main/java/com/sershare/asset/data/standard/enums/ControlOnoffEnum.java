package com.sershare.asset.data.standard.enums;

public enum ControlOnoffEnum {
    ON("开"),

    OFF("关"),;

    private String status;

    ControlOnoffEnum(String status) {
        this.status = status;
    }

    public static ControlOnoffEnum getControlOnoffEnumByStatus(String status){
        for(ControlOnoffEnum em : ControlOnoffEnum.values()){
            if(em.getStatus().equals(status)){
                return em;
            }
        }
        return null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
