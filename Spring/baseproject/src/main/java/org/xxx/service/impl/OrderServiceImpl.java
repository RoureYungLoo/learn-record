package org.xxx.service.impl;

import org.springframework.stereotype.Service;
import org.xxx.domain.Order;
import org.xxx.service.OrderService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> findAll() {
        System.out.println(">>> 业务方法 <<<");
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            orders.add(new Order((long) i, 100L + i, 200L + i));
        }
//        throw new RuntimeException("出错了");

        int i = 1/0;
//        System.out.println(">>> --------------- OrderServiceImpl.findAll() ------------- <<<");
//        return orders;
        return orders;
    }
}
