package org.example.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean(
            initMethod = "init",
            destroyMethod = "destroy"
    )
    @Scope("singleton")
    public Day day() {
        return new Day();
    }

    @Bean(
            initMethod = "init",
            destroyMethod = "destroy"
    )
//    @Scope("prototype")
    public Year year() {
        return new Year();
    }
}



