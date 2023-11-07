package org.example;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import javax.annotation.Resource;
@SpringBootTest
public class SpirngAmpqTest {
    @Resource
    RabbitTemplate rabbitTemplate;
    @Test
    public void test(){
        String queueName="simple.queue";
        String mes="hello, world";
        rabbitTemplate.convertAndSend(queueName,mes);
    }

}
