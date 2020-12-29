package com.aaron.gyz.common.exception;

/**
 * @Date: 2020/12/16 17:06
 * @Author: Aaron
 * @Description:
 */
public enum CloudEnum {

    E1001("E1001", "feign [%s] Exception: ");

    private String code;
    private String message;

    CloudEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

}
