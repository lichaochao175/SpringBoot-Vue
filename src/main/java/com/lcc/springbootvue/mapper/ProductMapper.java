package com.lcc.springbootvue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcc.springbootvue.domain.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @创建人 licc
 * @创建时间 2022/8/5
 */
@Mapper
public interface ProductMapper  extends BaseMapper<Product> {
}
