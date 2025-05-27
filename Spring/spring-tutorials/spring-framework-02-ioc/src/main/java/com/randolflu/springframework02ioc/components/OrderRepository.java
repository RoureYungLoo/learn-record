package com.randolflu.springframework02ioc.components;

import org.springframework.stereotype.Repository;

//@Repository
public class OrderRepository {
    private Long id;

    @Override
    public String toString() {
        return "OrderRepository{" +
                "id=" + id +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderRepository(Long id) {
        this.id = id;
    }

    public OrderRepository() {
    }
}
