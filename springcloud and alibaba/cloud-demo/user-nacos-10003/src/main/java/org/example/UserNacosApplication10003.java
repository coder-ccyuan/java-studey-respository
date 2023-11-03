package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("org.example.mapper")
public class UserNacosApplication10003 {
    public static void main(String[] args) {
        SpringApplication.run(UserNacosApplication10003.class,args);
    }
}
