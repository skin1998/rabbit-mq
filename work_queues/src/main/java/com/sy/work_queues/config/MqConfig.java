package com.sy.work_queues.config;

import org.springframework.amqp.core.Queue;
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

    //创建队列
    @Bean
    public Queue queue() {
        //创建一个队列队列，并指定队列的名字
        return new Queue(QUEEN_NAME_ONE, true);
    }
}
