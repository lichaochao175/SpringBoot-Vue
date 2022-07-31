package com.lcc.springbootvue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lcc.springbootvue.base.Resp;
import com.lcc.springbootvue.domain.entity.User;
import com.lcc.springbootvue.domain.dto.UserDto;

/**
 * @author lichaochao
 * @data 2022/5/26 10:18 AM
 **/
public interface UserService  extends IService<User> {


    User getUserBymobile(String mobile);

    Resp checkUser(UserDto userDto);
}
