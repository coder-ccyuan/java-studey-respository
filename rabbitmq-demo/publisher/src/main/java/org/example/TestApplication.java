package org.example;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class TestApplication {
    @Resource
    RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {

    }
}
