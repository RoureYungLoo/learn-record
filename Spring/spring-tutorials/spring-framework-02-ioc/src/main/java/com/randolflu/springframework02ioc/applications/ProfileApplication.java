package com.randolflu.springframework02ioc.applications;

import com.randolflu.springframework02ioc.datasource.DataSourceConfig;
import com.randolflu.springframework02ioc.datasource.DataSourceDev;
import com.randolflu.springframework02ioc.datasource.DataSourceTest;
import com.randolflu.springframework02ioc.entity.Hello;
import com.randolflu.springframework02ioc.lifecycle.Config;
import com.randolflu.springframework02ioc.lifecycle.DevConfig;
import com.randolflu.springframework02ioc.lifecycle.TestConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

public class ProfileApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("test", "dev");

        context.register(DevConfig.class, TestConfig.class, DataSourceConfig.class);

        context.refresh();

        Hello bean1 = (Hello) context.getBean("helloDev");
        Hello bean2 = (Hello) context.getBean("helloTest");
        System.out.println(bean1.getHelloStr());
        System.out.println(bean2.getHelloStr());


        DataSourceDev dsDev = (DataSourceDev) context.getBean("dataSourceDev");
        DataSourceTest dsTest = (DataSourceTest) context.getBean("dataSourceTest");

    }
}
