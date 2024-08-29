package com.xxx.config;

import com.xxx.dao.PenDao;
import com.xxx.dao.PenDaoImpl;
import com.xxx.dao.People;
import com.xxx.service.PenService;
import com.xxx.service.PenServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = {"com.xxx.dao", "com.xxx.service"})
@PropertySource("classpath:db.properties")
public class Config4 {

    @Bean
    public static PropertySourcesPlaceholderConfigurer create() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Bean
    public PenDao getPenDao() {
        return new PenDaoImpl();
    }

    @Bean
    public PenService getPenService(
            @Value("${jdbc.username}") String name,
            @Value("${jdbc.password}") String password) {
        System.out.println(name + " " + password);
        return new PenServiceImpl();
    }

    @Bean
    // @Scope("singleton")
    @Scope("prototype")
    // @Scope("request")
    // @Scope("session")
    public  People getPeople() {
        return new People();
    }
}
