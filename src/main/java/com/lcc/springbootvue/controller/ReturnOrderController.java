package com.lcc.springbootvue.controller;

import com.lcc.springbootvue.service.impl.ReturnOrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger log =LoggerFactory.getLogger(ReturnOrderController.class);

    private ReturnOrderServiceImpl returnOrderService;

    public ReturnOrderController( ReturnOrderServiceImpl returnOrderService){
        this.returnOrderService=returnOrderService;
    }

//    @GetMapping("get")
}
