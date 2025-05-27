package com.randolflu.springframework02ioc.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @PostConstruct
    public void postConstruct() {
//        System.out.println("---  已经初始化 " + this.getClass().getTypeName());
    }

    @PreDestroy
    public void preDestroy() {
//        System.out.println("------ 即将销毁 " + this.getClass().getTypeName());
    }

    public long getId() {
        return orderRepository.getId();
    }

}
