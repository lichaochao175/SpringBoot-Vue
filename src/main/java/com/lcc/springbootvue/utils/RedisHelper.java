package com.lcc.springbootvue.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author lichaochao
 * @data 2022/7/1 2:29 PM
 **/
public class RedisHelper {


  @Autowired
  private RedisTemplate redisTemplate;

}
