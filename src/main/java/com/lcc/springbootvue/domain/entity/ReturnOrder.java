package com.lcc.springbootvue.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcc.springbootvue.domain.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("return_order")
public class ReturnOrder  extends BaseTime {
  @TableId(type= IdType.AUTO)
  private long id;
  private long originalId;
  private Integer orderNum;
  private Integer uId;
  private String targetAddress;
  /**
   *  订单状态：
   *    0：已完成
   *    1:未完成
   */
  private String orderStatus;
  private BigDecimal orderPrice;
  private BigDecimal orderTotalPrice;

}
