package com.lcc.springbootvue.handler;

import com.alibaba.fastjson.JSON;
import com.lcc.springbootvue.constant.CommonConst;
import com.lcc.springbootvue.constant.enums.StatusCodeEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登陆未处理
 *
 * @author Licc
 * @date 2022/7/27 9:41 PM
 */
@Component
public class AuthenticationEntryPointImpl   implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType(CommonConst.APPLICATION_JSON);
        httpServletResponse.getWriter().write(JSON.toJSONString(StatusCodeEnum.NO_LOGIN));
    }
}