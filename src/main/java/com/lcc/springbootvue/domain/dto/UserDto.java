package com.lcc.springbootvue.domain.dto;


import com.lcc.springbootvue.domain.CommEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author lichaochao
 * @data 2022/5/26 10:22 AM
 **/
@Data
@Accessors(chain=true)
public class UserDto  extends CommEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 手机号
     */
    @NotEmpty
    @Length(min = 11 , message = "手机号只能为11位")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String mobile;


    /**
     * 密码
     */
    @NotEmpty(message = "请填写密码")
    private String password;
}
