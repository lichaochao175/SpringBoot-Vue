package com.lcc.springbootvue.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("store")
public class Store {

  private long id;
  private String name;
  private String storeAddress;
  private long maxNum;
  private long userId;
  private String status;
  private LocalDateTime creatTime;
  private LocalDateTime  updateTime;



}
