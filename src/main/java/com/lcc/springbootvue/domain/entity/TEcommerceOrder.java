package com.lcc.springbootvue.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcc.springbootvue.domain.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author lichaochao
 * @data 2022/7/6 6:25 PM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_commerce_order")
public class TEcommerceOrder  extends BaseTime {
    private Integer id;
    private  Integer userId;
    @TableField("address_id")
    private Integer addressId;
    @TableField("order_detail")
    private String orderDetail;

}
