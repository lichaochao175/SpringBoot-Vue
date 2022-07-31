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
  private long orderNum;
  private String targetAddress;
  private String orderStatus;
  private BigDecimal orderPrice;
  private BigDecimal orderTotalPrice;


}
