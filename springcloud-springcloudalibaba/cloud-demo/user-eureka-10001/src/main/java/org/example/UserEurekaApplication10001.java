package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
@MapperScan("org.example.mapper")
public class UserEurekaApplication10001 {
    public static void main(String[] args) {
        SpringApplication.run(UserEurekaApplication10001.class,args);
    }
}
