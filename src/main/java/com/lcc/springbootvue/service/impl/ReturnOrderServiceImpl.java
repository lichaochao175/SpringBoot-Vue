package com.lcc.springbootvue.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcc.springbootvue.domain.base.BaseId;
import com.lcc.springbootvue.domain.dto.ReturnOrderTotalDto;
import com.lcc.springbootvue.domain.entity.ReturnOrder;
import com.lcc.springbootvue.mapper.ReturnOrderMapper;
import com.lcc.springbootvue.mapper.UserDao;
import com.lcc.springbootvue.service.ReturnOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnOrderServiceImpl extends ServiceImpl<ReturnOrderMapper, ReturnOrder> implements ReturnOrderService {

    private UserDao userDao;
    private  ReturnOrderMapper returnOrderMapper;

    public ReturnOrderServiceImpl(UserDao userDao,ReturnOrderMapper returnOrderMapper){
        this.userDao =userDao;
        this.returnOrderMapper=returnOrderMapper;
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


}
