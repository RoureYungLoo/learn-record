package com.randolflu.springframework02ioc.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {
    @Bean
    @Profile("dev")
    public DataSourceDev dataSourceDev() {
        return new DataSourceDev();
    }

    @Bean
    @Profile("test")
    public DataSourceTest dataSourceTest() {
        return new DataSourceTest();
    }

}
