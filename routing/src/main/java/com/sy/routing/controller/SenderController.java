package com.sy.routing.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.sy.routing.config.MqConfig;

import javax.annotation.Resource;

@RestController
public class SenderController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sender/hello/{message}/{rout}")
    public String senderHello(@PathVariable String message,@PathVariable String rout) {
        /*
         * 参数说明
         * exchnage: 交换机
         * routingKey ：发送消息的路由键
         * message:消息的内容
         */
        rabbitTemplate.convertAndSend(MqConfig.EXCHANGE_DIRECT,rout,message);
        return "success";
    }
}

