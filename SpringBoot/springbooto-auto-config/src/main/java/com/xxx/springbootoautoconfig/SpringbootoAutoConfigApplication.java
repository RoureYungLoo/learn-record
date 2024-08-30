package com.xxx.springbootoautoconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootoAutoConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootoAutoConfigApplication.class, args);
        Object dispatcherServlet = context.getBean("dispatcherServlet");

        System.out.println(dispatcherServlet);

        /* 获取自定义的common-pojo-2.0 */
        System.out.println(context.getBean("province"));
        System.out.println(context.getBean("country"));

    }

}
