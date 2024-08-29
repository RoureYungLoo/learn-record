package com.xxx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SpringMVCSupport extends WebMvcConfigurationSupport {
    @Override
    /* 处理静态资源 */
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 访问静态资源时，不要使用SpringMVC容器处理
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }
}
