package com.xxx.config;

import com.xxx.dao.DogDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.xxx.dao"})
public class Config2 {

    @Bean
    public String show(DogDao dogDao){
        System.out.println("完成自动注入："+dogDao);
        dogDao.findAll();
        return  null;
    }



}
