package com.lcc.springbootvue.controller;

import com.lcc.springbootvue.base.Resp;
import com.lcc.springbootvue.domain.base.BaseId;
import com.lcc.springbootvue.domain.dto.UserDto;
import com.lcc.springbootvue.service.impl.UserServiceImpl;
import com.lcc.springbootvue.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Security;

/**
 * @author lichaochao
 * @data 2022/5/26 10:20 AM
 **/
@RestController
@RequestMapping("/user")
// 1。后端解决跨域
@CrossOrigin
@Slf4j
public class UserController {

    private UserServiceImpl userServiceImpl;
    private RedisTemplate redisTemplate;


    @Autowired
    public UserController(UserServiceImpl userServiceImpl,RedisTemplate redisTemplate) {
        this.userServiceImpl = userServiceImpl;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 登陆接口
     * @param userDto
     * @return
     */
    @PostMapping("/login")
    public Resp login(@Validated  @RequestBody UserDto userDto){
        return Resp.suc(userServiceImpl.login(userDto));
    }


    /**
     * 认证成功返回信息
     * @return
     */
    @PostMapping("/info")
    public Resp info(){
        Subject subject = SecurityUtils.getSubject();
        String token = (String)subject.getPrincipal();
        Integer role = JWTUtil.getRole(token);
        JWTUtil.getUsername(token);
        return Resp.suc(token);
    }

    @GetMapping("/test")
    public String checkLogin(@RequestBody  BaseId baseId){
        log.info("请求进入！！！！！");
        return  "!23124123";
    }

}
