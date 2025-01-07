package com.xxx.springboot.config;

import com.xxx.springboot.domain.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Student student() {
        return new Student();
    }
}
