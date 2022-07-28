package com.lcc.springbootvue.domain.entity;


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
public class Role {
     private Integer id;
     private String name;
}