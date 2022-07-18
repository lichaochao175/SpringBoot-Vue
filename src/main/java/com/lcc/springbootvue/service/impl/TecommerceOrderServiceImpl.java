package com.lcc.springbootvue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcc.springbootvue.domain.entity.TEcommerceOrder;
import com.lcc.springbootvue.domain.vo.CheckVO;
import com.lcc.springbootvue.mapper.TEcommerceOrderMapper;
import com.lcc.springbootvue.service.TecommerceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lichaochao
 * @data 2022/7/6 6:31 PM
 **/
@Service
public class TecommerceOrderServiceImpl extends ServiceImpl<TEcommerceOrderMapper, TEcommerceOrder> implements TecommerceOrderService {

    private TEcommerceOrderMapper tEcommerceOrderMapper;

    @Autowired
    public TecommerceOrderServiceImpl(TEcommerceOrderMapper tEcommerceOrderMapper){
        this.tEcommerceOrderMapper = tEcommerceOrderMapper;
    }


    public List<CheckVO> tEcommerceOrderMapper(){
      return   tEcommerceOrderMapper.checkVo();
    }


}
