package com.randolflu.springframework02ioc.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public HelloLifeCycle lifecycle() {
        return new HelloLifeCycle();
    }
}
