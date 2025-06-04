package com.randolflu.springframework02ioc.applications;

import com.randolflu.springframework02ioc.datasource.DataSourceConfig;
import com.randolflu.springframework02ioc.datasource.DataSourceDev;
import com.randolflu.springframework02ioc.datasource.DataSourceTest;
import com.randolflu.springframework02ioc.entity.Hello;
import com.randolflu.springframework02ioc.lifecycle.DevConfig;
import com.randolflu.springframework02ioc.lifecycle.HelloLifeCycle;
import com.randolflu.springframework02ioc.lifecycle.TestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@ComponentScan("com.randolflu.springframework02ioc.config.stu")
//public class ProfileApplication2 {
//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(SpringFramework02IocApplication6.class);
//    }}

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.randolflu.springframework02ioc.lifecycle",
        "com.randolflu.springframework02ioc.datasource"
})
public class ProfileApplication2 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProfileApplication2.class);

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

//        ConfigurableApplicationContext context = SpringApplication.run(ProfileApplication2.class);
//        context.getEnvironment().setActiveProfiles("test", "dev");
//
//        context.register(DevConfig.class, TestConfig.class, DataSourceConfig.class);
//
//        context.refresh();

        HelloLifeCycle lifecycle = (HelloLifeCycle) context.getBean("lifecycle");
        lifecycle.hello();

        Hello bean1 = (Hello) context.getBean("helloDev");
        Hello bean2 = (Hello) context.getBean("helloTest");
        System.out.println(bean1.getHelloStr());
        System.out.println(bean2.getHelloStr());


        DataSourceDev dsDev = (DataSourceDev) context.getBean("dataSourceDev");
        DataSourceTest dsTest = (DataSourceTest) context.getBean("dataSourceTest");

    }
}
