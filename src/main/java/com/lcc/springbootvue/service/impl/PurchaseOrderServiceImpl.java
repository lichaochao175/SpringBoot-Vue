package com.lcc.springbootvue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcc.springbootvue.domain.entity.PurchaseOrder;
import com.lcc.springbootvue.mapper.PurchaseOrderMapper;
import com.lcc.springbootvue.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

/**
 * @author Licc
 * @date 2022/8/13 12:59 PM
 */
@Service
public class PurchaseOrderServiceImpl   extends ServiceImpl<PurchaseOrderMapper, PurchaseOrder> implements PurchaseOrderService {
}