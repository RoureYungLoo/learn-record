package com.randolflu.springframework03aop.aspect4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Order order2(){
        return new Order(10000001L,2000002L,30000003L);
    }
}
