package com.lcc.springbootvue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcc.springbootvue.domain.entity.Order;
import com.lcc.springbootvue.mapper.OrderDao;
import com.lcc.springbootvue.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lichaochao
 * @data 2022/7/1 7:56 PM
 **/
@Service
public class OrderServiceImpl  extends ServiceImpl<OrderDao , Order>implements OrderService {
    private OrderDao  orderDao;

    @Autowired
    public OrderServiceImpl (OrderDao  orderDao){
        this.orderDao = orderDao;
    }

    public List<Order> getListByflagStatus() {
        List<Order> orders = orderDao.selectList(null);
        //过滤未完成订单
        List<Order> list = orders.stream().filter(o->("1").equals(o.getFlagStatus()))
                                    .collect(Collectors.toList());
        return list;

    }
}
