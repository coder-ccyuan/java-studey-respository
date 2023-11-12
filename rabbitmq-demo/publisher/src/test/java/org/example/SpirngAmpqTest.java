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

    /**
     * 工作模型：多个消费者共同消费多条消息，一条消息只能被一个消费者使用，之后消息在队列中销毁
     */
    @Test
    public void workerQueueTest(){//工作模型
        String queueName="simple.queue";
        String mes="hello, world__";
        for(int i=1;i<=50;i++){
            System.out.println(i);
            //发送到队列
            rabbitTemplate.convertAndSend(queueName,mes+i);
        }
    }

    /**
     * 发送订阅模型：将消息发送到交换机，队列绑定到交换机，之后队列将消息发送到消费者，期间一条消息可以给多个消费者使用
     */
    @Test
    public void workerPublishFanoutTest() {//发送订阅模型
        //交换机名
        String exchangeName = "fanout";
        //发送的消息
        String mes = "hello, everyone";
        //发送给交换机
        rabbitTemplate.convertAndSend(exchangeName, "", mes);
    }

    /**
     * 路由模式：在发送订阅模型上对队列增加了key,一个队列可以有多个key
     */
    @Test
    public void directExchangeTest(){
        //交换机名
        String exchangeName = "direct";
        //发送的消息
        String mes = "hello, one";
        //发送给交换机
        rabbitTemplate.convertAndSend(exchangeName, "yellow", mes);
    }

    /**
     * topic模式：在路由模式上对keyBing 增加多级key 如 china.jiangxi
     */
    @Test
    public void topicExchangeTest(){
        //交换机名
        String exchangeName = "topic";
        //发送的消息
        String mes = "hello, one";
        //发送给交换机
        rabbitTemplate.convertAndSend(exchangeName, "china.jiangxi", mes);
    }
}
