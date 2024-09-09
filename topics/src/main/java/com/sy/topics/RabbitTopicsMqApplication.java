package com.sy.topics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitTopicsMqApplication {

    //广播+路由+通配符
    public static void main(String[] args) {
        SpringApplication.run(RabbitTopicsMqApplication.class, args);
    }

}
