package com.lcc.springbootvue.domain.dto;


import com.sun.istack.internal.NotNull;
import lombok.Data;


@Data
public class ReturnOrderTotalDto {

    /**
     * 用户id
     */
    @NotNull
    private Integer uId;

    /**
     * 查询指定月份退单数量
     */
    private String  month;
}
