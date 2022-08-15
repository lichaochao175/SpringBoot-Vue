package com.lcc.springbootvue.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lcc.springbootvue.constant.Consts;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author Licc
 * @date 2022/7/31 6:53 PM
 */

public class JWTUtil {

    private static final long EXPIRE_TIME = 60 * 60 * 1000;

    /**
     * 校验token是否正确
     * @param token  密钥
     * @return 是否正确
     */
    public static boolean verify(String token) {
        try {
            //根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256("x");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(Consts.mobile, JWTUtil.getUsername(token))
                    .build();
            //效验TOKEN
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 生成签名
     * @param mobile
     * @param name
     * @param roleId
     * @param ids
     * @return
     */
    public static String sign(String mobile, String name, String roleId, List<Integer> ids) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256("x");
        String jwtId = UUID.randomUUID().toString();
        // 附带username信息
        return JWT.create()
                .withJWTId(jwtId)
                .withClaim(Consts.mobile, mobile)
                .withClaim(Consts.U_USERNAME,name)
                .withClaim(Consts.ROLE_IDS,roleId)
                //权限
//                .withClaim(Consts.PERMISSIONS,ids)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static Integer getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("mobile").asInt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    /**
     * 获取角色
     * @param token
     * @return
     */
    public static Integer getRole(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(Consts.ROLE_IDS).asInt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    /**
     * 获得token中的信息无需secret解密也能获得
     *  手机号
     * @return
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(Consts.mobile).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }





    public static void main(String[] args) {
//        String token = sign("aaa", "123456");
//        System.out.println("token:" + token);
//        System.out.println(getUserId(token));
//        System.out.println(getUsername(token));
//        System.out.println(verify(token, "aaa", "123456"));
    }



}