package com.dnslin.onemanager.result;

public enum ResponseEnum {

    SUCCESS("200","success"),
    SYSTEM_ERROR("500","发生未知异常。。。"),
    SK_BUSY("4001","网络故障"),
    ID_NOTFOUND("4002","状态错误"),
    LIST_ERROR("4003","数据格式异常"),
    Cookie_not_found("4004","Cookie获取失败"),
    Token_invalid("4005","Token失效"),
    PARAMETERS_ARE_MISSING("4006","参数缺失"),
    AUTH_CODE_ISNULL("4007","Auth Code 为空");


    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
