package com.lcc.springbootvue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcc.springbootvue.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author Licc
 * @date 2022/7/28 8:30 PM
 */
@Mapper
public interface RoleDao  extends BaseMapper<Role> {
}