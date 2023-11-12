package org.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    /**
     *
     * @return 返回一个交换机
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout");
    }

    /**
     *
     * @return 返回一个队列1
     */
    @Bean
    public Queue fanoutQueue1(){
        return new Queue("fanout.queue1");
    }
    /**
     *
     * @return 返回一个队列2
     */
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("fanout.queue2");
    }

    /**
     *
     * @param fanoutQueue1 队列1
     * @param fanout 交换机
     * @return 将队1列绑定到交换机
     */
    @Bean
    public Binding fanoutBinding( Queue fanoutQueue1, FanoutExchange fanout){
        return BindingBuilder.bind(fanoutQueue1).to(fanout);
    }
    /**
     *
     * @param fanoutQueue2 队列2
     * @param fanout 交换机
     * @return 将队列2绑定到交换机
     */
    @Bean
    public Binding fanoutBinding2( Queue fanoutQueue2, FanoutExchange fanout){
        return BindingBuilder.bind(fanoutQueue2).to(fanout);
    }
    @Bean
    public Queue objectQueue(){
        return new Queue("object.queue");
    }
    @Bean
    public MessageConverter json(){
        return new Jackson2JsonMessageConverter();
    }
}
