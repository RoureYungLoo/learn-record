package com.randolflu.springframework02ioc.config;

import com.randolflu.springframework02ioc.components.OrderRepository;
import com.randolflu.springframework02ioc.components.OrderService;
import com.randolflu.springframework02ioc.config2.CarEntity;
import com.randolflu.springframework02ioc.entity.User;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

import static org.springframework.boot.BootstrapRegistry.Scope.*;

/* 表明这是一个 Java 配置类 */
@Configuration
/* 指定了类扫描的包名 */
//@ComponentScan("com.randolflu.springframework02ioc.config")
@ComponentScan(
        basePackages = "com.randolflu.springframework02ioc.config"
        /* 包含basePackages包下指定组件 */
//        ,includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Stub.*Repository")
//        , includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {OrderRepository.class, OrderService.class})

        /* 排除basePackages包下指定组件 */
//        , excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {UserService.class})
//        , excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class})
)
@Import(value = {CarEntity.class})
@ImportResource("classpath:beans5.xml")
public class UserConfig {


    @Bean(
            value = "user",
            name = "user",
            autowire = Autowire.NO,
            autowireCandidate = true,
            initMethod = "postConstruct",
            destroyMethod = "preDestroy"
    )
    @Scope("prototype")
//    @Scope("singleton")
    @Lazy
    public User user() {
        return new User();
    }

//    @Bean
//    public OrderService orderService() {
//        return new OrderService();
//    }

//    @Bean
//    public OrderRepository orderRepository(){
//        return new OrderRepository();
//    }
}
