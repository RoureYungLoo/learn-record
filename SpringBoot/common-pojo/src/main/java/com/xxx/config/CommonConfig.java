package com.xxx.config;

import com.xxx.pojo.Country;
import com.xxx.pojo.Province;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

public class CommonConfig {

    public CommonConfig() {
    }


    @ConditionalOnProperty(
            prefix = "country",
            name = {"name", "system"})
    @Bean
    public Country country(
            @Value("${country.name}") String name,
            @Value("${country.system}") String system) {
        return new Country(name,system);
    }

    @Bean
    public Province province() {
        return new Province();
    }
}
