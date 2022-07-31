package com.lcc.springbootvue.shiro;

import com.lcc.springbootvue.domain.entity.User;
import com.lcc.springbootvue.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Licc
 * @date 2022/7/31 11:07 AM
 */
public class UserRealm   extends AuthorizingRealm {
    @Autowired
    UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取当前用户对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        System.out.print(currentUser);
        // 添加权限
        info.addStringPermission("user:add");

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取 登录用户 与数据库对比
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        User user = userMapper.getUserBymobile(userToken.getUsername());
        if(user == null){
            return null; // 抛出异常
        }
        // 密码认证 doGetAuthenticationInfo
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }

}