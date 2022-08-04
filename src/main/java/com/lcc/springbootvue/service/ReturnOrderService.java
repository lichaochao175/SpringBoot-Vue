package com.lcc.springbootvue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lcc.springbootvue.domain.base.BaseId;
import com.lcc.springbootvue.domain.dto.ReturnOrderTotalDto;
import com.lcc.springbootvue.domain.entity.ReturnOrder;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public interface ReturnOrderService  extends IService<ReturnOrder> {
    /**
     * 查询账户下所有退货订单(未完成)
     * @param baseId
     * @return
     */
    List<ReturnOrder> getByUserIdAll(BaseId baseId);

    int getReturnOrderNum(@Qualifier("query") ReturnOrderTotalDto dto);
}
