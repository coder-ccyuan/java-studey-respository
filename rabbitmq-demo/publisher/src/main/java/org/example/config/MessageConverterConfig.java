package org.example.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConverterConfig {
    /**
     * 配置rabbitmq将对象序列化的方式采用json
     * @return
     */
    @Bean
    public MessageConverter getJson(){
        return new Jackson2JsonMessageConverter();
    }
}
