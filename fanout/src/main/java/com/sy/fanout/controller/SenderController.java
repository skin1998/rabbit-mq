package com.sy.fanout.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sy.fanout.config.MqConfig;

import javax.annotation.Resource;

@RestController
public class SenderController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sender/hello/{message}")
    public String senderHello(@PathVariable String message) {
        /*
         * 参数说明
         * exchnage: 交换机
         * routingKey ：发送消息的路由键，默认为""
         * message:消息的内容
         */
        rabbitTemplate.convertAndSend(MqConfig.EXCHANGE_FANOUT,"",message);
        return "success";
    }
}

