package com.lcc.springbootvue.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcc.springbootvue.domain.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lichaochao
 * @data 2022/7/6 6:26 PM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_ecommerce_user")
public class TecommerceUser  extends BaseTime {

    private static final long serialVersionUID = 1L;
    /**
     * 通过雪花算法生成id
     */
    @TableId(type= IdType.ASSIGN_ID)
    private Integer id;
    private String username;
    private String password;
    private String extraInfo;

}
