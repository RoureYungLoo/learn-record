package com.xxx.config;

import com.xxx.dao.BookDao;
import com.xxx.dao.BookDaoImpl;
import com.xxx.dao.PenDao;
import com.xxx.dao.PenDaoImpl;
import com.xxx.service.BookService;
import com.xxx.service.BookServiceImpl;
import com.xxx.service.PenService;
import com.xxx.service.PenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.xxx.dao","com.xxx.service"})
public class Config3 {

    @Bean
    public PenDao getPenDao(){
        return new PenDaoImpl();
    }

    @Bean
    public PenService getPenService(PenDao penDao){
        System.out.println(penDao);
        return  new PenServiceImpl();
    }
}
