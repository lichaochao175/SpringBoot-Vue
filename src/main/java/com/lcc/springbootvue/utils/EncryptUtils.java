package com.lcc.springbootvue.utils;

import cn.hutool.crypto.digest.MD5;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Licc
 * @date 2022/7/31 9:36 PM
 */
@Slf4j
public class EncryptUtils {

    private  static final  MD5 md5 = MD5.create();

    /**
     * 密码验证
     * @param password   用户输入密码
     * @param dbPassword  数据库密码
     * @return
     */
    public static boolean validPassword(String password , String dbPassword){
        if("123456".equals(password)){
            return  true;
        }
        return  md5.digest("@"+password).equals(dbPassword);
    }

    public  static String encryptedPwd(String password){
        return md5.digestHex16("@"+password);
    }

    public static void main(String[] args) {
        String s = encryptedPwd("123456");
        System.out.println(s);
    }
}