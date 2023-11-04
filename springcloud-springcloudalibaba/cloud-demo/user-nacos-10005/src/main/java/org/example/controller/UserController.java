package org.example.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
public class UserController {
    @Resource
    UserService userService;
    @GetMapping("/user/get")
    public User getUse(Long id){
        User user = userService.getUser(id);
        return user;
    }
}
