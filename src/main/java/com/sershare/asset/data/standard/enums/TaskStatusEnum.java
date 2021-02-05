package com.sershare.asset.data.standard.enums;

public enum TaskStatusEnum {

    TASK_NOTDONE(12011,"未执行"),
    TASK_DOING(12012,"执行中"),
    TASK_SUCCESS(12013,"执行成功"),
    TASK_FAIL(12014,"执行失败"),
    TASK_STAND_BY(12015,"等待就绪"),
    ;

    private Integer code;

    private String msg;

    TaskStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static TaskStatusEnum getEnum(String name){
        for (TaskStatusEnum taskStatusEnum : TaskStatusEnum.values()) {
            if(taskStatusEnum.name().equalsIgnoreCase(name)){
                return taskStatusEnum;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
