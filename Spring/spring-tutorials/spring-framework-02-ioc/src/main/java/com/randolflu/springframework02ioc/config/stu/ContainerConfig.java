package com.randolflu.springframework02ioc.config.stu;

import com.randolflu.springframework02ioc.entity.ContainerInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContainerConfig {

    @Bean
    public ContainerInfo containerInfo(){
        return new ContainerInfo();
    }
}
