package com.randolflu.springframework02ioc.config.stu;

import com.randolflu.springframework02ioc.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean(
            initMethod = "beanInitMethod",
            destroyMethod = "beanDestroyMethod"
    )
    public Student student(){
        return new Student();
    }
}
