package com.randolflu.springframework02ioc.demo_property_source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:person.properties")
public class PersonConfig {
    @Bean
    public Person person() {
        return new Person();
    }
}

