package com.lcc.springbootvue.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.lcc.springbootvue.constant.CommonConst.APPLICATION_JSON;

/**
 *登陆失败处理
 *
 * @author Licc
 * @date 2022/7/27 9:55 PM
 */
@Component
public class AuthenticationFailHandlerImpl   implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
       httpServletResponse.setContentType(APPLICATION_JSON);
       httpServletResponse.getWriter().write(JSON.toJSONString(e.getMessage()));
    }
}