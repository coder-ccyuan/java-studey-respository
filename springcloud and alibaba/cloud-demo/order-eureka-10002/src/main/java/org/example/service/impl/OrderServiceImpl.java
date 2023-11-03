package org.example.service.impl;


import org.example.entity.Order;
import org.example.entity.User;
import org.example.mapper.OrderMapper;
import org.example.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;
    @Resource
    RestTemplate restTemplate;

    @Override
    public Order getOrder(Long id) {
        Order orderById = orderMapper.getOrderById(id);
        String url = "http://USER-EUREKA/user/get?id=" + orderById.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        orderById.setAddress(user.getAddress());
        orderById.setName(user.getName());
        return orderById;
    }
}
