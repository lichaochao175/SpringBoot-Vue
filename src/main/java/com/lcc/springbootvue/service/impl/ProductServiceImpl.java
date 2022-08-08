package com.lcc.springbootvue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcc.springbootvue.constant.CachConst;
import com.lcc.springbootvue.constant.Consts;
import com.lcc.springbootvue.domain.base.BaseId;
import com.lcc.springbootvue.domain.entity.Product;
import com.lcc.springbootvue.mapper.ProductMapper;
import com.lcc.springbootvue.service.ProductService;
import com.lcc.springbootvue.utils.RedisHelper;
import org.redisson.Redisson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @创建人 licc
 * @创建时间 2022/8/5
 */

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    private ProductMapper productMapper;

    private RedisTemplate redisTemplate;

    @Autowired
    public  ProductServiceImpl(ProductMapper productMapper,RedisTemplate redisTemplate ){
        this.productMapper = productMapper;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 修改商品数量
     *    解决并发操作：通过用户id作为key来实现
     * @param product
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateProductNum(Product product, BaseId userId) {
        String locKey = "product_";
        redisTemplate.opsForValue().set(CachConst.USER_ID, userId);

        //判断是否为同一用户
       String uid = (String)redisTemplate.opsForValue().get(CachConst.USER_ID);
       if( userId.equals(uid)){


       }
        //判断新增是否成功  0 成功  1 失败
        if( productMapper.update(product, new QueryWrapper<Product>().eq("id", product.getId())) > 0){
            return  0 ;
        }
        return  1;
    }

    /**
     * 缓存所有商品到redis中
     *   key:前缀+product_id
     */
    public  void   cacheProduct(){
        List<Product> products = productMapper.selectList(null);
        for ( Product  product: products){
             redisTemplate.opsForValue().set( CachConst.REDIS_PRODUCT+product.getId(), product);
        }
    }

    /**
     * 新增商品
     * @param product
     * @return
     */
    public int inserProduct(Product product){
        //判断新增是否成功  0 成功  1 失败
        if(productMapper.insert(product) >0){
            //新增成功添加到redis
            redisTemplate.opsForValue().set(CachConst.REDIS_PRODUCT+product.getId(),product);
            return  0;
        }
        return  1;
    }

}
