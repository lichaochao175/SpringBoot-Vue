package com.lcc.springbootvue.utils;

import cn.hutool.core.lang.Assert;
import com.lcc.springbootvue.domain.entity.User;
import com.lcc.springbootvue.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * @author Licc
 * @date 2022/7/27 10:27 PM
 */

@Component
public class UserUtils {
    @Autowired
    UserMapper userMapper;

    private static UserUtils  userUtils ;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @PostConstruct
    public void init( ){
        userUtils =this;
        userUtils.userMapper = this.userMapper;
    }

    public static User getUser(){
        //获取Authorization 中token
        String token = (String)SecurityUtils.getSubject().getPrincipal();
        //解密token中mobile
        String mobile = JWTUtil.getUsername(token);
        User user = userUtils.userMapper.getUserBymobile(mobile);
        Assert.isNull(user,"token解析失败，未获取相关用户信息");
        return  user;
    }


}