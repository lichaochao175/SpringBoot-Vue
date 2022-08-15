package com.lcc.springbootvue.controller;

import com.lcc.springbootvue.base.Resp;
import com.lcc.springbootvue.domain.dto.ReturnOrderTotalDto;
import com.lcc.springbootvue.service.impl.ReturnOrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @创建人 licc
 * @创建时间 2022/8/4
 * 退单表
 */

@RestController
@RequestMapping("returnOrder")
public class ReturnOrderController {
    private final  Logger log =LoggerFactory.getLogger(ReturnOrderController.class);

    private final  ReturnOrderServiceImpl returnOrderService;

    public ReturnOrderController( ReturnOrderServiceImpl returnOrderService){
        this.returnOrderService=returnOrderService;
    }

    /**
     * 获取退单详情
     * @param dto
     * @return
     */
    @GetMapping("get")
    public Resp  getReturnOrder(@Validated  ReturnOrderTotalDto dto){
        int returnOrderNum = returnOrderService.getReturnOrderNum(dto);
        return Resp.suc(returnOrderNum);
    }

}
