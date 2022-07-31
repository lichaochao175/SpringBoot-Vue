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
 *销售表 sale_order
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sale_order")
public class SaleOrder   extends BaseTime {
  /**
   * 通过雪花算法生成id
   */
  @TableId(type= IdType.ASSIGN_ID)
  private long id;

  /**
   * 销售单编号
   */
  private Integer saleId;

  /**
   * 销售数量
   */
  private long orderNum;

  /**
   * 目的地
   */
  private String targetAddress;
  private String orderStatus;
  private BigDecimal orderPrice;
  private BigDecimal orderTotalPrice;


}
