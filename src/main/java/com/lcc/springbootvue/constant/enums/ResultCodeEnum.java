package com.lcc.springbootvue.constant.enums;

/**
 * 应用返回值状态码
 *
 * @author : moon
 */
public enum ResultCodeEnum {

    // 成功
    OK(2000, "操作成功！"),

    // 断言错误
    ASSERTION_ERROR(402, "很抱歉，出现自定义错误！"),

    // 获取锁失败
    TRY_LOCK_FAIL(101, "请求繁忙，请稍后再试"),

    // 请求参数有误（1、语义有误，当前请求无法被服务器理解。除非进行修改，否则客户端不应该重复提交这个请求。2、请求参数有误。）
    PARAMS_ERROR(400, "很抱歉，您的参数有误！"),

    // 身份验证错误(对不起，我不知道你是谁)
    UNAUTHORIZED(401, "很抱歉，您未通过身份验证，请重新登录！"),

    // 无访问权限（对不起，我知道你是谁，但你没有访问权限）
    FORBIDDEN(403, "很抱歉，您没有访问权限，请重新登录！"),

    // 找不到资源
    NOT_FOUND(404, "很抱歉，您需要的资源找不到了！"),

    // 服务器发生错误
    SERVER_ERROR(500, "很抱歉，服务器开了个小差，请联系客服！");

    /**
     * 错误编码
     **/
    private final int code;
    /**
     * 错误描述
     **/
    private final String description;


    ResultCodeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
