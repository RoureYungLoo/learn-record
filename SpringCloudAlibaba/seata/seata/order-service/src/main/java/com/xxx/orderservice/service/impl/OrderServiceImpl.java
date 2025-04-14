package com.xxx.orderservice.service.impl;

import com.xxx.orderservice.dao.OrderDao;
import com.xxx.orderservice.domain.Order;
import com.xxx.orderservice.feign.AccountServiceFeignClient;
import com.xxx.orderservice.feign.StorageServiceFeignClient;
import com.xxx.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageServiceFeignClient storageService;

    @Autowired
    private AccountServiceFeignClient accountService;

    @Override
    public Boolean createOrder(Order order) {

        System.out.println("=== 开始创建订单");
        orderDao.createOrder(order);
        System.out.println("=== 订单创建成功");

        System.out.println("=== 开始扣减库存");
        storageService.decrease(order.getProductId(), order.getCount());
        System.out.println("=== 库存扣减成功");

        System.out.println("=== 开始扣减用户余额");
        accountService.decrease(order.getUserId(), order.getMoney());
        System.out.println("=== 用户余额扣减成功");

        System.out.println("=== 开始更新订单状态");
        orderDao.updateStatus(order.getUserId(), 0);
        System.out.println("=== 订单状态更新成功");

        return Boolean.TRUE;
    }
}
