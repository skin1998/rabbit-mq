package com.sy.fanout.handler;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.sy.fanout.config.MqConfig;

@Component
public class ReceiveHandler {

    //监听NAME_HELLO队列
    @RabbitListener(queues = {MqConfig.QUEEN_NAME_ONE})
    public void receiveHelloQueueMessage(String msg, Message message, Channel channel) {
        System.out.println("消费者ONE收到消息:"+msg);
    }

    //监听NAME_HELLO队列
    @RabbitListener(queues = {MqConfig.QUEEN_NAME_TWO})
    public void receiveHelloQueueMessageTwo(String msg, Message message, Channel channel) {
        System.out.println("消费者TWO收到消息:"+msg);
    }
}
