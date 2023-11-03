package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Order;

@Mapper
public interface OrderMapper {
    public Order getOrderById(@Param("id")Long id);





}
