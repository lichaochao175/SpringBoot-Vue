package com.lcc.springbootvue.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcc.springbootvue.domain.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 采购表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("purchase_order")
public class PurchaseOrder  extends BaseTime {

  private static final long serialVersionUID = 1L;

  @TableId(type= IdType.AUTO)
  private long id;
  /**
   * 采购订单
   */
  private Integer orderId;
  /**
   * 用户id
   */
  private Integer uId;
  /**
   * 采购数量
   */
  private long orderNum;
  /**
   * 目标地址
   */
  private String targetAddress;
  /**
   * 订单状态
   */
  private String orderStatus;
  /**
   * 订单价格
   */
  private BigDecimal orderPrice;
  /**
   * 订单总量
   */
  private BigDecimal orderTotalPrice;


}
