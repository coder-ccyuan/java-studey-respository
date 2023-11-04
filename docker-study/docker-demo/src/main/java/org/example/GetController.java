package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
@RequestMapping("/get")
public class GetController {
    @GetMapping("/getNow")
    public String getNow(){
        Date date = new Date();
        return date.toString();
    }
}
