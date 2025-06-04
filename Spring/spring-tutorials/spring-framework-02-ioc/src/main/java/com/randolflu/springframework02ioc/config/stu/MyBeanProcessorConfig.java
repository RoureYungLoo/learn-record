package com.randolflu.springframework02ioc.config.stu;

import com.randolflu.springframework02ioc.entity.HelloBean;
import com.randolflu.springframework02ioc.processor.MyBeanProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class MyBeanProcessorConfig {

    @Bean
    public HelloBean helloBean() {
        return new HelloBean();
    }

    @Bean
    public MyBeanProcessor myBeanProcessor(){
        return new MyBeanProcessor();
    }
}
