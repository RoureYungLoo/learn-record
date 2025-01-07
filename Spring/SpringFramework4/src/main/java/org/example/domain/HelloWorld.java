package org.example.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

//public class HelloWorld {
public class HelloWorld implements InitializingBean, DisposableBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init() {
        System.out.println("自定义init()");
    }

    @Override
    public void destroy() {
        System.out.println("自定义destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用 afterPropertiesSet()");

    }

//    @Override
//    public String toString() {
//        return "HelloWorld{" +
//                "message='" + message + '\'' +
//                '}';
//    }
}
