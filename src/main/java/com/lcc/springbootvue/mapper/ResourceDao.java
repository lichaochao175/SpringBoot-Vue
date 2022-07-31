package com.lcc.springbootvue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcc.springbootvue.domain.entity.Resource;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Licc
 * @date 2022/7/29 6:20 AM
 */
@Mapper
public interface ResourceDao extends BaseMapper<Resource> {
}