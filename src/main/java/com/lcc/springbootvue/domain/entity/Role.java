package com.lcc.springbootvue.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Licc
 * @date 2022/7/28 8:28 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class Role {
     private final  static long serialVersionUID= 1L;

     private Integer id;
     private String name;
}