package com.lcc.springbootvue.quartz;

import com.lcc.springbootvue.domain.entity.Order;
import com.lcc.springbootvue.mapper.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author lichaochao
 * @data 2022/7/1 7:37 PM
 **/

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
//@EnableScheduling
@Slf4j
public class Task {

    @Autowired
    private OrderDao orderDao;

    private int  i = 0;
    /**
     * 每个5秒wan
     */
//    @Scheduled(cron = "*/1 * * * *  ?")
    public  void updateTaske(){
        log.info("获取的值：[{}]"+i);
        i++;
        Order order = new Order();
        if(i%2==0){
            order.setOrderName("订单"+i);
            order.setFlagStatus("1");
        }else{
            order.setOrderName("订单"+i);
            order.setFlagStatus("0");
        }
        orderDao.insert(order);
        System.out.println("执行job");
    }
}
