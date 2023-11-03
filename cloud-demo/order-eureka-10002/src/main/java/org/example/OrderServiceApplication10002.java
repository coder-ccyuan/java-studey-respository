package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("org.example.mapper")
@SpringBootApplication
@EnableEurekaClient
public class OrderServiceApplication10002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication10002.class,args);
    }
}
