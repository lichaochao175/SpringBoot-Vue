package com.lcc.springbootvue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lcc.springbootvue.base.Resp;
import com.lcc.springbootvue.domain.base.BaseId;
import com.lcc.springbootvue.domain.entity.Product;

/**
 * @创建人 licc
 * @创建时间 2022/8/5
 */
public interface ProductService  extends IService<Product> {


      int updateProductNum(Product product, BaseId userId);

       Resp updateProductNum(Product product);
}
