package com.lcc.springbootvue.controller;

import com.lcc.springbootvue.base.Resp;
import com.lcc.springbootvue.constant.CachConst;
import com.lcc.springbootvue.domain.entity.Product;
import com.lcc.springbootvue.service.impl.ProductServiceImpl;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lichaochao
 * @data 2022/6/18 11:00 AM
 **/
@RestController
@RequestMapping("product")
public class ProductController {

    private ProductServiceImpl productServiceimpl;

    @Autowired
    private RedisTemplate redisTemplate;

    public ProductController(ProductServiceImpl productServiceimpl){
        this.productServiceimpl=productServiceimpl;
    }


    /**
     * 测试数据入库并添加到缓存中
     * @param product
     * @return
     */
    @PostMapping("inserProduct")
    public Resp   cacheTest(@RequestBody Product product){
        return  productServiceimpl.inserProduct(product);
    }

    /**
     * 修改商品
     * @param product
     * @return
     */
    @PostMapping("updateProduct")
    public Resp updateProduct(@RequestBody Product product){
        return  productServiceimpl.updateProductNum(product);
    }

    /**
     * 获取redis中商品
     */
    @GetMapping("getRedis")
    public Product getRedis(){
        return (Product)redisTemplate.opsForValue().get(CachConst.REDIS_PRODUCT +"16");
    }


    /**
     * 缓存所有商品
     * @return
     */
    @GetMapping("cacheProduct")
    public Resp cacheProduct(){
      return productServiceimpl.cacheProduct();
    }
}
