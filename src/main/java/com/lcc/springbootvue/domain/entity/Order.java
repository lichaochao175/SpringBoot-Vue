package com.lcc.springbootvue.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcc.springbootvue.domain.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author lichaochao
 * @data 2022/7/1 7:54 PM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_order")
public class Order extends  BaseTime {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String orderName;
    private String  checkName;
    private  String flagStatus;
}
