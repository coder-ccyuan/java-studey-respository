package org.example.service.impl;

import cpy.feign.clients.UserClient;
import cpy.feign.entity.User;
import org.example.entity.Order;
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
    @Resource
    UserClient userClient;

    @Override
    public Order getOrder(Long id) {
        Order orderById = orderMapper.getOrderById(id);
//        String url = "http://user-nacos/user/get?id=" + orderById.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
        User user = userClient.getUse(orderById.getUserId());
        orderById.setAddress(user.getAddress());
        orderById.setName(user.getName());
        return orderById;
    }
}
