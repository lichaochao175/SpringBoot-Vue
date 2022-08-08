package com.lcc.springbootvue.controller;

import com.lcc.springbootvue.domain.entity.Product;
import com.lcc.springbootvue.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

/**
 * @author lichaochao
 * @data 2022/6/18 11:00 AM
 **/
@RestController
@RequestMapping("product")
public class ProductController {

    private ProductServiceImpl productServiceimpl;

    public ProductController(ProductServiceImpl productServiceimpl){
        this.productServiceimpl=productServiceimpl;
    }


    /**
     * 测试数据入库并添加到缓存中
     * @param product
     * @return
     */
    @PostMapping("cacheInser")
    public int   cacheTest(@RequestBody Product product){

        return  productServiceimpl.inserProduct(product);
    }
}
