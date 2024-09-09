package com.sy.topics.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author 邵越
 * @Date 2024/9/9
 * @Description rabbit-mq配置类
 */
@Configuration
public class MqConfig {
    //消息队列的名字
    public static final String QUEEN_NAME_ONE = "queen_one";
    public static final String QUEEN_NAME_TWO = "queen_two";
    public static final String QUEEN_NAME_THREE = "queen_three";

    public static final String EXCHANGE_TOPIC = "exchnage-topic";

    @Bean
    public Exchange exchange() {
        //定义一个direct类型的交换机，并指定持久化
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPIC).durable(true).build();
    }


    //创建队列
    @Bean
    public Queue queueOne() {
        //创建一个队列队列，并指定队列的名字和持久化
        return new Queue(QUEEN_NAME_ONE, true);
    }

    //创建队列
    @Bean
    public Queue queueTwo() {
        //创建一个队列队列，并指定队列的名字和持久化
        return new Queue(QUEEN_NAME_TWO, true);
    }

    //创建队列
    @Bean
    public Queue queueThree() {
        //创建一个队列队列，并指定队列的名字和持久化
        return new Queue(QUEEN_NAME_THREE, true);
    }


    //#：匹配一个或多个词
    //
    //*：匹配不多不少恰好1个词

    @Bean
    public Binding bindQueueOne() {
        //aa.success
        return BindingBuilder.bind(queueOne())
                .to(exchange())
                .with("*.success")
                .noargs();
    }


    @Bean
    public Binding bindQueueTwo() {
        //aa.aa.success
        //aa.success
        //success
        return BindingBuilder.bind(queueTwo())
                .to(exchange())
                .with("#.success")
                .noargs();
    }

    @Bean
    public Binding bindQueueThree() {
        return BindingBuilder.bind(queueThree())
                .to(exchange())
                .with("*.error")
                .noargs();
    }
}
