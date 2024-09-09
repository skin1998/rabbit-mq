package com.sy.hello_world.handler;

import com.rabbitmq.client.Channel;
import com.sy.hello_world.config.MqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveHandler {

    //监听NAME_HELLO队列
    @RabbitListener(queues = {MqConfig.QUEEN_NAME_ONE})
    public void receiveHelloQueueMessage(String msg, Message message, Channel channel) {
        System.out.println("消费者收到消息:"+msg);
    }


}
