package com.lcc.springbootvue.domain.vo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author Licc
 * @date 2022/7/31 7:08 PM
 */

@Data
@ToString
@Accessors(chain = true)
public class LoginTokenVo {
    private String token;
}