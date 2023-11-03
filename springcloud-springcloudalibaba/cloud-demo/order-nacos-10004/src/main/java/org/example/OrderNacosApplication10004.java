package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("org.example.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosApplication10004 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication10004.class,args);
    }
}
