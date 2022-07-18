package com.lcc.springbootvue.base;

import lombok.Getter;

/**
 * @author : cchao
 * @version 2019-01-30
 */
@Getter
public enum Codes {

    // 0+ 通用异常
    SUC(2000, "请求成功"),
    Auth_Fail(3000, "auth fail"),
    Fail_NULL(5000, "auth null"),
    BAD_REQUEST(400, "Bad Request"),
    FAIL(1, "请求失败"),
    V_FAIL(2, "请求参数验证失败"),
    ERROR(10, "系统繁忙"),

    PRODUCT_NOT_EXIST(4, "RESULT.PRODUCT_NOT_EXIST"),
    FILE_EMPTY(5, "RESULT.FILE_EMPTY"),
    PARAM_MISSING(6, "请求参数缺失"),

    // 1000+ 用户
    UN_EXIST_USER(1001, "RESULT.UN_EXIST_USER"),
    LOGIN_SUC(1002, "RESULT.LOGIN_SUC"),
    LOGIN_FAIL(1003, "RESULT.LOGIN_FAIL"),
    EMAIL_EXIST(1004, "RESULT.EMAIL_EXIST"),
    WISH_EXIST(1005, "RESULT.WISH_EXIST"),
    WISH_SUC(1005, "RESULT.WISH_SUC"),
    TOKEN_EXPIRED(1201, "RESULT.TOKEN_EXPIRED"),

    // 4000+ 帖子
    UN_EXIST_POST(4010, "RESULT.UN_EXIST_POST"),
    UN_EXIST_COMMENT(4020, "RESULT.UN_EXIST_COMMENT"),
    UN_EXIST_REPLY(4030, "RESULT.UN_EXIST_REPLY"),
    ;

    private Integer code;
    private String message;

    Codes(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Codes msg(String msg) {
        this.message = msg;
        return this;
    }
}
