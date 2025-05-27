package com.randolflu.springframework02ioc.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Student implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
//        System.out.println("调用销毁前的回调");
        System.out.println("DisposableBean.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        System.out.println("所有依赖已经注入");
        System.out.println("InitializingBean.afterPropertiesSet");
    }

    public void initMethod() {
        System.out.println("<bean init-method 属性 />");
    }

    public void destroyMethod() {
        System.out.println("<bean destroy-method 属性 /> ");

    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("JSR250 @PostConstruct ");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("JSR250  @PreDestroy ");
    }

    public void beanInitMethod(){
        System.out.println("@Bean initMethod ");

    }

    public void beanDestroyMethod(){
        System.out.println("@Bean destroyMethod ");

    }

}
