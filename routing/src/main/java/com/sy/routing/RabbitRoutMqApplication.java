package com.sy.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitRoutMqApplication {

    //广播+路由
    public static void main(String[] args) {
        SpringApplication.run(RabbitRoutMqApplication.class, args);
    }

}
