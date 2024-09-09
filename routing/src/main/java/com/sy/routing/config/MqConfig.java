package com.sy.routing.config;

import com.sy.routing.enums.ExchangeEnum;
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

    public static final String EXCHANGE_DIRECT = ExchangeEnum.DIRECT.getName();

    @Bean
    public Exchange exchange(){
        //定义一个direct类型的交换机，并指定持久化
        return ExchangeBuilder.directExchange(EXCHANGE_DIRECT).durable(true).build();
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

    @Bean
    public Binding bindQueueOne(){
        //不指定routingKey
        return BindingBuilder.bind(queueOne()).to(exchange()).with("success").noargs();
    }

    @Bean
    public Binding bindQueueTwo(){
        //不指定routingKey
        return BindingBuilder.bind(queueTwo()).to(exchange()).with("success").noargs();
    }

    @Bean
    public Binding bindQueueThree(){
        //不指定routingKey
        return BindingBuilder.bind(queueThree()).to(exchange()).with("error").noargs();
    }
}
