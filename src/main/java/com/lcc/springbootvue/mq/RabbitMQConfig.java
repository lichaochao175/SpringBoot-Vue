package com.lcc.springbootvue.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author lichaochao
 * @data 2022/5/18 8:27 AM
 **/
@Configuration
@Slf4j
public class RabbitMQConfig {
//
//    private final RabbitTemplate rabbitTemplate;
//
//    public RabbitMQConfig(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }

//
//    @PostConstruct
//    public void enableConfirmCallback() {
//        //confirm 监听，当消息成功发到交换机 ack = true，没有发送到交换机 ack = false
//        //correlationData 可在发送时指定消息唯一 id
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//            if(!ack){
//                //记录日志、发送邮件通知、落库定时任务扫描重发
//            }
//        });
//
//        //当消息成功发送到交换机没有路由到队列触发此监听
//        rabbitTemplate.setReturnsCallback(returned -> {
//            //记录日志、发送邮件通知、落库定时任务扫描重发
//        });
//    }
//}

    public  static final  String QUEUE = "queue";
    public  static final String TOPIC_QUEUE1 = "topic.queue1";
    public  static final String TOPIC_QUEUE2 = "topic.queue2";
    public  static final  String TOPIC_EXCHANGE = "topicExchange";


    @Bean
    public Queue topicQueue() {
        return new Queue("sss",true);
    }




}
