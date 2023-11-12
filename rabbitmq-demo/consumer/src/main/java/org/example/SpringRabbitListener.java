package org.example;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SpringRabbitListener {
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessages1(String msg) throws InterruptedException {
        Thread.sleep(20);
        System.err.println("message1" + msg);
    }

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessages2(String msg) throws InterruptedException {
        Thread.sleep(10);
        System.out.println("message2" + msg);
    }

    //发布订阅模式
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueueMessages1(String msg) throws InterruptedException {
        Thread.sleep(20);
        System.err.println("queue1" + msg);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueueMessages2(String msg) throws InterruptedException {
        Thread.sleep(10);
        System.out.println("queue2" + msg);
    }

    //路由模式
    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "direct.queue1"), exchange = @Exchange(name = "direct", type = ExchangeTypes.DIRECT), key = {"red"}))
    public void listenDirectQueueMessages1(String msg) throws InterruptedException {
        Thread.sleep(10);
        System.out.println("queue1red" + msg);
    }
    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "direct.queue2"), exchange = @Exchange(name = "direct", type = ExchangeTypes.DIRECT), key = {"yellow"}))
    public void listenDirectQueueMessages2(String msg) throws InterruptedException {
        Thread.sleep(10);
        System.out.println("queue2yellow" + msg);
    }
    //topic模式
    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "topic.queue1"), exchange = @Exchange(name = "topic", type = ExchangeTypes.TOPIC), key = {"china.#"}))
    public void listenTopicQueueMessages1(String msg) throws InterruptedException {
        Thread.sleep(10);
        System.out.println("topicQueue1" + msg);
    }
    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "topic.queue2"), exchange = @Exchange(name = "topic", type = ExchangeTypes.TOPIC), key = {"china.jiangxi"}))
    public void listenTopicQueueMessages2(String msg) throws InterruptedException {
        Thread.sleep(10);
        System.out.println("topicQueue2" + msg);
    }
    @RabbitListener(queues = "object.queue")
    public void listenObjectQueueMessages(HashMap<Integer,String> msg) throws InterruptedException {
        Thread.sleep(10);
        System.out.println("queue2" + msg);
    }
}
