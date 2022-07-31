package com.lcc.springbootvue.domain.base;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Licc
 * @date 2022/7/30 8:41 PM
 */
@Data
public class BaseDate   implements Serializable {
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime  updateTime;
}