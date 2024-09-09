package com.sy.fanout.config;

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

    public static final String EXCHANGE_FANOUT = "exchange_fanout";

    //定义一个fanout类型的交换机，并指定持久化
    @Bean
    public Exchange exchange(){
        //定义一个fanout类型的交换机，并指定持久化
        return ExchangeBuilder.fanoutExchange(EXCHANGE_FANOUT).durable(true).build();
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

    @Bean
    public Binding bindQueueOne(){
        //不指定routingKey
        return BindingBuilder.bind(queueOne()).to(exchange()).with("").noargs();
    }

    @Bean
    public Binding bindQueueTwo(){
        //不指定routingKey
        return BindingBuilder.bind(queueTwo()).to(exchange()).with("").noargs();
    }
}
