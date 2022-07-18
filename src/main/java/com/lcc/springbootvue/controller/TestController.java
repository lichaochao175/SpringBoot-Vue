package com.lcc.springbootvue.controller;

import com.alibaba.fastjson.JSON;
import com.lcc.springbootvue.constant.CachConst;
import com.lcc.springbootvue.domain.entity.Order;
import com.lcc.springbootvue.mapper.OrderDao;
import com.lcc.springbootvue.service.impl.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lichaochao
 * @data 2022/7/1 5:59 PM
 **/
@RestController
@RequestMapping("test")
public class TestController {

    public Logger log = LoggerFactory.getLogger(TestController.class);
    private RedisTemplate redisTemplate;

    private OrderServiceImpl orderServiceImpl;

    @Autowired
    public  TestController(RedisTemplate redisTemplate, OrderServiceImpl orderServiceImpl) {
        this.redisTemplate = redisTemplate;
        this.orderServiceImpl=orderServiceImpl;
    }
    /**
     * 测试redis缓存
     * @param mobile
     */
    @PostMapping("/checkMessage")
    public void checkMoblie(@RequestBody String mobile){
        redisTemplate.opsForValue().set(CachConst.Validatae_code_tag+2, JSON.toJSONString(mobile));
    }

    @PostMapping("/getRedisCache")
    public String getRedisCache(@RequestParam String str){
        Object o = redisTemplate.opsForValue().get(str);
        System.out.println(str);
        log.info("获取到的值：【{}】",str);
        return o.toString();
    }

    @GetMapping("getExpiration")
    public List<Order> getRedisInsert(){
       return orderServiceImpl.getListByflagStatus();
    }

}
