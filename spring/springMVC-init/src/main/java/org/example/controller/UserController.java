package org.example.controller;


import com.mysql.cj.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @GetMapping(value = "/login")

    public String login(String username, String password, HttpServletRequest request) {

        System.out.println(username);
        System.out.println("login---------");
        return "ok";
    }
}
