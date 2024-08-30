package com.xxx.springbootregister;

import com.xxx.pojo.Country;
import com.xxx.pojo.Province;
import com.xxx.springbootregister.annotation.EnableCommonConfig;
import config.CommonConfig;
import config.CommonImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
// @Import(CommonConfig.class) // 注册 Bean
//@Import(value = {CommonConfig.class}) // 注册 Bean

// 导入ImportSelector的实现类
// @Import(CommonImportSelector.class)

/* 自定义注解，用于测试注册Bean */
@EnableCommonConfig

public class SpringbootRegisterApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringbootRegisterApplication.class, args);

        // 通过类名获取
//        Country country = context.getBean(Country.class);
//        System.out.println(country);

        // 通过对象名获取
        // System.out.println(context.getBean("yindu"));
        // System.out.println(context.getBean("henan"));


        Province province = context.getBean(Province.class);
        System.out.println(province);
    }


}
