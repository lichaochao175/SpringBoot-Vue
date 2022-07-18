package com.lcc.springbootvue.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lichaochao
 * @data 2022/7/1 8:05 PM
 **/
@Getter
@Setter
public class BaseTime  implements Serializable {
    /**
     * 开始时间
     */
    @TableField(value="create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    /**
     * 结束时间
     */
    @TableField(value="update_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

}
