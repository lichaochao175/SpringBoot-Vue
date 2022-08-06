package com.lcc.springbootvue.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcc.springbootvue.domain.entity.Product;
import com.lcc.springbootvue.mapper.ProductMapper;
import com.lcc.springbootvue.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @创建人 licc
 * @创建时间 2022/8/5
 */

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
