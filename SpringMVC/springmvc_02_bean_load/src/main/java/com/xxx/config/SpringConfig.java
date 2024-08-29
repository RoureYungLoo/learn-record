
package com.xxx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/* Spring 配置类（） */
@Configuration
// @ComponentScan(basePackages = {"com.xxx.service","com.xxx.dao"})
@ComponentScan( // 过滤 com.xxx 包下的 @Controller 注解
        basePackages = "com.xxx",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Controller.class
        )
)
public class SpringConfig {
}
