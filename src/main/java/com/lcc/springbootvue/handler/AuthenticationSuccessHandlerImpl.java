package com.lcc.springbootvue.handler;

import com.alibaba.fastjson.JSON;
import com.lcc.springbootvue.domain.entity.User;
import com.lcc.springbootvue.mapper.UserDao;
import com.lcc.springbootvue.service.UserService;
import com.lcc.springbootvue.utils.BeanCopyUtils;
import com.lcc.springbootvue.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.lcc.springbootvue.constant.CommonConst.APPLICATION_JSON;

/**
 * @author Licc
 * @date 2022/7/27 9:58 PM
 */
@Component
public class AuthenticationSuccessHandlerImpl  implements AuthenticationSuccessHandler {
    @Autowired
    private UserDao userDao;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User user = BeanCopyUtils.copyObject(UserUtils.getLoginUser(), User.class);
        httpServletResponse.setContentType(APPLICATION_JSON);
        httpServletResponse.getWriter().write(JSON.toJSONString(user));
        // 更新用户ip，最近登陆时间
        updateUserInfo();
    }
    @Async
    public void updateUserInfo() {
        User userAuth = User.builder()
                .id(UserUtils.getLoginUser().getId())
                .ipAddress(UserUtils.getLoginUser().getIpAddress())
                .ipSource(UserUtils.getLoginUser().getIpSource())
//                .lastLoginTime(UserUtils.getLoginUser().getLastLoginTime())
                .build();
        userDao.updateById(userAuth);
    }
}