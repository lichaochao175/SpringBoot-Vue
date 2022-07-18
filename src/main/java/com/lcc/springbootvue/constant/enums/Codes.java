package com.lcc.springbootvue.constant.enums;

import lombok.Getter;

/**
 * @author lichaochao
 * @data 2022/5/27 2:58 PM
 **/
@Getter
public enum Codes {


    SUC(200,"请求成功"),
    FAIL(500,"请求失败")
    ;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    Codes(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
