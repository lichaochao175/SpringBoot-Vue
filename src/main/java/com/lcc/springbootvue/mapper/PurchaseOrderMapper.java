package com.lcc.springbootvue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcc.springbootvue.domain.entity.PurchaseOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseOrderMapper  extends BaseMapper<PurchaseOrder> {
}
