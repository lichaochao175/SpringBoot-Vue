package com.lcc.springbootvue.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcc.springbootvue.base.Resp;
import com.lcc.springbootvue.constant.CachConst;
import com.lcc.springbootvue.domain.base.BaseId;
import com.lcc.springbootvue.domain.entity.Product;
import com.lcc.springbootvue.domain.entity.PurchaseOrder;
import com.lcc.springbootvue.domain.entity.User;
import com.lcc.springbootvue.mapper.ProductMapper;
import com.lcc.springbootvue.mapper.PurchaseOrderMapper;
import com.lcc.springbootvue.service.ProductService;
import com.lcc.springbootvue.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @创建人 licc
 * @创建时间 2022/8/5
 */

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    private final ProductMapper productMapper;

    private final RedisTemplate redisTemplate;

    private final PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    public  ProductServiceImpl(ProductMapper productMapper,RedisTemplate redisTemplate ,PurchaseOrderMapper purchaseOrderMapper){
        this.productMapper = productMapper;
        this.redisTemplate = redisTemplate;
        this.purchaseOrderMapper=purchaseOrderMapper;
    }

    @Override
    public int updateProductNum(Product product, BaseId userId) {
        return 0;
    }

    /**
     * 修改商品数量
     * 解决并发操作：通过用户id作为key来实现
     *
     * @param product //     * @param userId
     * @return
     */
    @Override
    public Resp updateProductNum(Product product) {
        String locKey = "product_";

        //判断商品库存是否符合扣减 =>redis
        Integer num =(Integer) redisTemplate.opsForValue().get(CachConst.REDIS_PRODUCT+product.getId());

        if( num <= 0 || num < product.getNum()){
            return Resp.fail( "商品数量不足已扣减");
        }
        //更新redis 中数量 并异步更新数据库
        redisTemplate.opsForValue().set(CachConst.REDIS_PRODUCT+product.getId(),num - product.getNum());
        updateDBProduct(product,product.getNum());
        //生成订单
        //获取当前用户id
        return Resp.suc();
    }


    /**
     * 修改商品数量
     * @param product
     * @param num
     */
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void updateDBProduct(Product product,Integer num){

        Product obj = productMapper.selectById(product.getId());
        int i = obj.getNum() - num;
        obj.setNum(i);
        productMapper.updateById(obj);
        int j = 1/0;
    }

    /**
     * 缓存所有商品到redis中
     *   key:前缀+product_id  value : 商品数量
     */
    public  Resp   cacheProduct(){
        List<Product> products = productMapper.selectList(null);
        for ( Product  product: products){
             redisTemplate.opsForValue().set( CachConst.REDIS_PRODUCT+product.getId(), product.getNum());
        }
       return Resp.suc("缓存成功");
    }

    /**
     *  新增商品
     * @param product
     * @return
     */
    public Resp inserProduct(Product product){
        //判断新增是否成功  0 成功  1 失败
        User user = UserUtils.getUser();
        if(productMapper.insert(product) >0){
            //新增成功添加到redis
            redisTemplate.opsForValue().set(CachConst.REDIS_PRODUCT+product.getId(),product);
            return  Resp.suc("添加成功");
        }
        return  Resp.fail("添加失败");
    }

}
