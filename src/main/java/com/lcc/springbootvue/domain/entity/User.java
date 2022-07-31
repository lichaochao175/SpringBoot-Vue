package com.lcc.springbootvue.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcc.springbootvue.domain.BaseTime;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author lichaochao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("sys_user")
@ToString
public class User  extends BaseTime {

  private static final long serialVersionUID = 1L;
  /**
   * 通过雪花算法生成id
   */
  @TableId(type= IdType.ASSIGN_ID)
  private Integer id;
  private String mobile;
  private String roleId;
  private String username;
  private String password;
  private char sex;
  private String address;

  private char flagStatus;
  /**
   * ip地址
   */
  private String  ipAddress;

  /**
   * ip来源
   */
  private String ipSource;
}