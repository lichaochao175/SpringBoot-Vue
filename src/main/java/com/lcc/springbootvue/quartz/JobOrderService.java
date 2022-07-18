package com.lcc.springbootvue.quartz;

import com.lcc.springbootvue.domain.entity.Order;
import com.lcc.springbootvue.mapper.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lichaochao
 * @data 2022/7/4 5:09 PM
 **/
@Slf4j
@Component
public class JobOrderService {
    @Autowired
    private OrderDao orderDao;


    int i = 0;
    public void business() {
        i++;
        log.info("JobOrder，业务方法执行,thread:{},i:{}", Thread.currentThread().getName(), i);
        log.info("获取的值：[{}]"+i);
        i++;
        Order order = new Order();
        if(i%2==0){
            order.setOrderName("订单"+i);
            order.setFlagStatus("1");
            order.setUserId(i);
        }else{
            order.setOrderName("订单"+i);
            order.setFlagStatus("0");
            order.setUserId(i);
        }
        orderDao.insert(order);
        System.out.println("执行job");
    }
}
