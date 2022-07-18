package com.lcc.springbootvue.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author lichaochao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
@ToString
public class User  {

  @TableId(type= IdType.AUTO)
  private Integer id;
  private String mobile;
  private String username;
  private String password;
  private Data createTime;
  private Data updateTime;

}