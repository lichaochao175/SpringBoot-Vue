package com.lcc.springbootvue.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcc.springbootvue.domain.base.BaseId;
import com.lcc.springbootvue.domain.base.BaseIds;
import com.lcc.springbootvue.domain.dto.ReturnOrderTotalDto;
import com.lcc.springbootvue.domain.entity.ReturnOrder;
import com.lcc.springbootvue.mapper.ProductMapper;
import com.lcc.springbootvue.mapper.ReturnOrderMapper;
import com.lcc.springbootvue.mapper.UserDao;
import com.lcc.springbootvue.service.ReturnOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnOrderServiceImpl extends ServiceImpl<ReturnOrderMapper, ReturnOrder> implements ReturnOrderService {

    private UserDao userDao;
    private  ReturnOrderMapper returnOrderMapper;
    private ProductMapper productMapper;

    public ReturnOrderServiceImpl(UserDao userDao,ReturnOrderMapper returnOrderMapper, ProductMapper productMapper){
        this.userDao =userDao;
        this.returnOrderMapper=returnOrderMapper;
        this.productMapper= productMapper;
    }
    /**
     * 查询账户下所有退货订单(未完成)
     * @param baseId
     * @return
     */
    @Override
    public List<ReturnOrder> getByUserIdAll(BaseId baseId) {
        return returnOrderMapper.selectList(
                new QueryWrapper<ReturnOrder>()
                        .eq("uId", baseId)
                        .eq("orderStatus", 1)
        );
    }

    /**
     *  根据月份查询退单情况
     * @param dto
     * @return
     */
    @Override
    public int getReturnOrderNum(ReturnOrderTotalDto dto) {
        return  returnOrderMapper.getReturnOrderNum(dto);
    }


    /**
     * 当退单信息确认退单完毕，相应的商品会回退到商品表中
     * @return
     */
    public int updateProductNum(BaseIds baseIds){
        //根据退单id查询出来并修改状态为0
        ReturnOrder returnOrder = returnOrderMapper.selectById(baseIds.getId());
        returnOrder.setOrderStatus("0");
        int i = returnOrderMapper.updateById(returnOrder);
        //将退单详情中商品数量添加到商品表中 TODO 通过异步+事务调用商品表更新数量
       return  i;
    }


}
