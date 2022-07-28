package com.lcc.springbootvue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcc.springbootvue.domain.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lichaochao
 * @data 2022/7/1 7:53 PM
 **/
 @Mapper
public interface OrderDao  extends BaseMapper<Order> {
}
