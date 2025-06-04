package com.randolflu.springframework02ioc.lifecycle;

import com.randolflu.springframework02ioc.entity.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Bean
    public Hello helloTest(){
        return new Hello("激活了test环境");
    }
}
