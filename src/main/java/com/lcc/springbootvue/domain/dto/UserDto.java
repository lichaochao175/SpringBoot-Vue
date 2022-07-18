package com.lcc.springbootvue.domain.dto;


import com.lcc.springbootvue.domain.CommEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author lichaochao
 * @data 2022/5/26 10:22 AM
 **/
@Data
@Accessors(chain=true)
public class UserDto  extends CommEntity {

    private String mobile;

    private String password;
}
