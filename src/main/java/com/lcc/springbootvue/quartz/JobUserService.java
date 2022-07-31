package com.lcc.springbootvue.quartz;

import com.lcc.springbootvue.domain.entity.User;
import com.lcc.springbootvue.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lichaochao
 * @data 2022/7/6 9:21 PM
 **/
@Slf4j
@Component
public class JobUserService {
    @Autowired
    private UserMapper userMapper;

    int i = 0;

    public  void userJob(){
        i++;
        log.info("JobUser 定时任务，业务方法执行,thread:{},i:{}", Thread.currentThread().getName(), i);
        log.info("获取的值：[{}]"+i);
        i++;
        User user = new User();
        if(i%2==0){
            user.setUsername("测试人员1"+i);
            user.setPassword("password+"+i);
        }else{
            user.setUsername("测试人员1"+i);
            user.setPassword("password+"+i);
        }
        userMapper.insert(user);
        System.out.println("执行job");
    }
}
