package com.lcc.springbootvue.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcc.springbootvue.domain.CommEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("store")
public class Store  extends CommEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 通过雪花算法生成id
   */
  @TableId(type= IdType.ASSIGN_ID)
  private long id;
  private String name;
  private String storeAddress;
  private long maxNum;
  private long userId;
  private String status;
  private LocalDateTime creatTime;
  private LocalDateTime  updateTime;



}
