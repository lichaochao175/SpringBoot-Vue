package com.lcc.springbootvue.controller;

import com.lcc.springbootvue.domain.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lichaochao
 * @data 2022/7/7 8:36 AM
 **/
@RestController
@RequestMapping("mq")
public class RabbitMQController {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping("/multiSend")
    public String multiSend(){
        StringBuilder times=new StringBuilder();
        for(int i=0;i<1000;i++){
            long time=System.nanoTime();
            rabbitTemplate.convertAndSend("sss","第"+i+"次发送的时间："+time);
            times.append(time+"<br>");
        }
        return times.toString();
    }

    @PostMapping("push")
    public String push(@RequestBody Order order){
        rabbitTemplate.convertAndSend("sss",order);
        return "ssss";
    }

    @GetMapping("getAlll")
    public String getAll(){
        MessageConverter messageConverter = rabbitTemplate.getMessageConverter();
        return "ssss";
    }



}
