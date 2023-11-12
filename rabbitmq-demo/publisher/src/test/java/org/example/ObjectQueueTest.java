package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;

@SpringBootTest
public class ObjectQueueTest {
    @Resource
    RabbitTemplate rabbitTemplate;
    @Test
    public void test(){
    String queueName="object.queue";
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"张三");
        map.put(2,"李四");
        rabbitTemplate.convertAndSend(queueName,map);
    }
}
