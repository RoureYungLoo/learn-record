package com.xxx.config;

import com.xxx.entity.Apple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"com.xxx.entity"})
public class Config5 {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Apple getApple(){
        return  new Apple();
    }
}
