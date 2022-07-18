package com.lcc.springbootvue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcc.springbootvue.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lichaochao
 * @data 2022/5/26 10:19 AM
 **/

@Mapper
public interface UserDao  extends BaseMapper<User> {
}
