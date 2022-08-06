package com.lcc.springbootvue.domain.base;

import lombok.Data;

/**
 * @创建人 licc
 * @创建时间 2022/8/5
 */
@Data
public class BaseIds {
    /**
     * 表的主键id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer uId;
    /**
     * 商品id
     */
    private Integer pId;
}
