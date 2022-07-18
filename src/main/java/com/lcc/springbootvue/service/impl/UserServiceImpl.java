package com.lcc.springbootvue.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcc.springbootvue.base.Resp;
import com.lcc.springbootvue.constant.enums.ResultCodeEnum;
import com.lcc.springbootvue.domain.entity.User;
import com.lcc.springbootvue.domain.dto.UserDto;
import com.lcc.springbootvue.mapper.UserDao;
import com.lcc.springbootvue.service.OrderService;
import com.lcc.springbootvue.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author lichaochao
 * @data 2022/5/26 10:20 AM
 **/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Resp checkUser(UserDto userDto) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",userDto.getMobile());
        User user = userDao.selectOne(wrapper);
        log.info("获取到对象:{}",user);
        if(ObjectUtil.isEmpty(user)){
            // 密码不一致
            return Resp.fail(ResultCodeEnum.UNAUTHORIZED,"对象为空");
        }
        if(!user.getPassword().equals(userDto.getPassword())){
            // 密码不一致
            return Resp.fail(ResultCodeEnum.UNAUTHORIZED,"密码错误");
        }
        return Resp.suc(user);
    }

}
