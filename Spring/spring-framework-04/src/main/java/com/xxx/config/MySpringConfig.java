package com.xxx.config;

import com.xxx.entity.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration // 代表这个类是配置类
@Import(config2.class) // 导入另外一个配置类
public class MySpringConfig {

    // 使用 @Bean 注解注册 Bean，返回值类型是Bean的类型，方法名是 Bean 的 id
    @Bean
    public Dog dog(){
        return new Dog();
    }

}
