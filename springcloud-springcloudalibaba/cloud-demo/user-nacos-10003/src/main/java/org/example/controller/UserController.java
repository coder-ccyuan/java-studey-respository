package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
@Slf4j
@RefreshScope//开启配置中心文件热更新
public class UserController {
    @Resource
    UserService userService;
    @Value("${pattern.dateformat}")
    private String dateformat;
    @Value("${spring.application.name}")
    private String port;
    @GetMapping("/user/get")
    public User getUse(Long id){
        User user = userService.getUser(id);
        return user;
    }
    @GetMapping("/now")
    public String now(){
        System.out.println(port);
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
    }
}
