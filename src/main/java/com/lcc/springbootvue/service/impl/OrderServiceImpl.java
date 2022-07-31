package com.lcc.springbootvue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcc.springbootvue.domain.entity.Order;
import com.lcc.springbootvue.mapper.OrderMapper;
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
public class OrderServiceImpl  extends ServiceImpl<OrderMapper, Order> implements OrderService {
    private OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl (OrderMapper orderMapper){
        this.orderMapper = orderMapper;
    }

    public List<Order> getListByflagStatus() {
        List<Order> orders = orderMapper.selectList(null);
        //过滤未完成订单
        List<Order> list = orders.stream().filter(o->("1").equals(o.getFlagStatus()))
                                    .collect(Collectors.toList());
        return list;

    }
}
