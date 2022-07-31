package com.lcc.springbootvue.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lcc.springbootvue.domain.CommEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Licc
 * @date 2022/7/31 10:47 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role_menu")
public class SysRoleMenu   extends CommEntity {
    private static final long  serialVersionUID =1L;


    private Integer id;
    private Integer menuId;
}