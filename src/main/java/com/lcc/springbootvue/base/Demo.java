package com.lcc.springbootvue.base;

import lombok.Data;

/**
 * @author Licc
 * @date 2022/8/13 8:13 AM
 */

@Data
public class Demo<T>{


    private String code;
    private String message;
    private  T  Data;

    public  Demo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public  static <T> Demo<T>  of( String code , String message){
        return new Demo<T>(code,message);
    }


}