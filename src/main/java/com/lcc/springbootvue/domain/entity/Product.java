package com.lcc.springbootvue.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcc.springbootvue.domain.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @创建人 licc
 * @创建时间 2022/8/5
 *  商品表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("product")
public class Product  extends BaseTime {

    @TableId( value = "id" ,type = IdType.AUTO)
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 分类表id
     */
    private Integer categoryId;
    /**
     * 商品数量(库存)
     */
    private Integer num;
    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 预警数量
     */
    private  Integer warningNum;

}