package com.lcc.springbootvue.controller;

import com.alibaba.fastjson.JSON;
import com.lcc.springbootvue.base.Resp;
import com.lcc.springbootvue.constant.CachConst;
import com.lcc.springbootvue.domain.dto.UserDto;
import com.lcc.springbootvue.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author lichaochao
 * @data 2022/5/26 10:20 AM
 **/
@RestController
@RequestMapping("/login")
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

    @PostMapping("/checkLogin")
    public Resp checkLogin(@RequestBody UserDto userDto){
        return userServiceImpl.checkUser(userDto);
    }

    @GetMapping("/test")
    public String checkLogin(){
        return  "!23124123";
    }

}
