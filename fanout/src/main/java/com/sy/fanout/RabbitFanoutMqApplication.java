package com.sy.fanout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitFanoutMqApplication {
    //广播
    public static void main(String[] args) {
        SpringApplication.run(RabbitFanoutMqApplication.class, args);
    }

}
