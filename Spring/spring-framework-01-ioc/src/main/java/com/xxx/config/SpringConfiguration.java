package com.xxx.config;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;
import com.xxx.dao.*;
import com.xxx.service.BookService;
import com.xxx.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = {"com.xxx.dao","com.xxx.service"})
@PropertySource("classpath:db.properties")
public class SpringConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer create(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean  // 注入一个其他人编写的类
    public OtherDao getOtherDao(){
        return new OtherDao();
    }

    @Bean(name = "cdia")
    public CatDao getCatDaoA(){
        return new CatDaoImplA();
    }

    @Bean(name = "cdib")
    public CatDao getCatDaoB(){
        return new CatDaoImplB();
    }

}
