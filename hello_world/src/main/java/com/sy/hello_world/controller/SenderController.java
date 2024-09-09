package com.sy.hello_world.controller;

import com.sy.hello_world.config.MqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SenderController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sender/hello/{message}")
    public String senderHello(@PathVariable String message) {
        /*
         * 参数说明
         * exchnage: 交换机，默认交换机指定为“”即可
         * routingKey ：发送消息的路由键，该模式下使用队列名即可
         * message:消息的内容
         */
        rabbitTemplate.convertAndSend("", MqConfig.QUEEN_NAME_ONE,message);
        return "success";
    }
}

