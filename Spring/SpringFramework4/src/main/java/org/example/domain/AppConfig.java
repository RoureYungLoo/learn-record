package org.example.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Foo foo() {
        return new Foo(bar()); // 注入依赖关系
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }
}
