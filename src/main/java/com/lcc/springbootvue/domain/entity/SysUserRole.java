package com.lcc.springbootvue.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcc.springbootvue.domain.CommEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Licc
 * @date 2022/7/31 10:29 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user_role")
public class SysUserRole  extends CommEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 通过雪花算法生成id
     */
    @TableId(type= IdType.ASSIGN_ID)
    private Integer Id;
    private Integer userId;
}