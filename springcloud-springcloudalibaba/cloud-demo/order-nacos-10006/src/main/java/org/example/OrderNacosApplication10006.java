package org.example;

import cpy.feign.clients.UserClient;
import org.example.config.ConfigFeignClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("org.example.mapper")
@EnableFeignClients(clients = UserClient.class)//开启feign 远程调用
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosApplication10006 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication10006.class,args);
    }
}
