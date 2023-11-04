package org.example.controller;

import org.example.entity.Order;
import org.example.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    OrderService orderService;
    @GetMapping("/order/get/{id}")
    public Order getOrder(@PathVariable("id") Long id){
        Order order = orderService.getOrder(id);
        return order;
    }
}
