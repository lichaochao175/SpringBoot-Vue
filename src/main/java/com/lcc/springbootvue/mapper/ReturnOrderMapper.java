package com.lcc.springbootvue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcc.springbootvue.domain.dto.ReturnOrderTotalDto;
import com.lcc.springbootvue.domain.entity.ReturnOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReturnOrderMapper   extends BaseMapper<ReturnOrder> {

   /**
    * 根据月份获取退货情况
    * @param dto
    * @return
    */
   int getReturnOrderNum(ReturnOrderTotalDto dto);
}
