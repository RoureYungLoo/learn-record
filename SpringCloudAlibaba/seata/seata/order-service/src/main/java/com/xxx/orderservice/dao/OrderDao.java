package com.xxx.orderservice.dao;

import com.xxx.orderservice.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    void createOrder(Order order);
    void updateStatus(@Param("userId") Long userId, @Param("status") Integer status);
}
