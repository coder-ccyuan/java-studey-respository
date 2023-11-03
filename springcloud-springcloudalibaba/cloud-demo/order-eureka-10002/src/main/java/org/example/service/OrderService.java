package org.example.service;

import org.example.entity.Order;
import org.example.mapper.OrderMapper;

import javax.annotation.Resource;

public interface OrderService {
public Order getOrder(Long id);
}
