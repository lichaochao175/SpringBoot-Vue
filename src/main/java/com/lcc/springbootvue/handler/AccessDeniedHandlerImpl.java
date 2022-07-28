package com.lcc.springbootvue.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.lcc.springbootvue.constant.CommonConst.APPLICATION_JSON;

/**
 * 注销处理
 * @author Licc
 * @date 2022/7/27 9:47 PM
 */
@Component
public class AccessDeniedHandlerImpl  implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType(APPLICATION_JSON);
        //todo 需要封装结果集
        httpServletResponse.getWriter().write("注销成功");
    }
}