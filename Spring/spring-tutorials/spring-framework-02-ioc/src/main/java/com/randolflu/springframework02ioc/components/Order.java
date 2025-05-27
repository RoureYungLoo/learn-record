package com.randolflu.springframework02ioc.components;


import org.springframework.stereotype.Component;

//@Component
@Component(value = "order")
public class Order {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }

    public Order() {
    }

    public Order(Long id) {
        this.id = id;
    }
}
