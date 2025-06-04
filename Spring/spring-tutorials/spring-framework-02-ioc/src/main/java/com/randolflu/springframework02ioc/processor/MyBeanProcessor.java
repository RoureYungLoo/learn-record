package com.randolflu.springframework02ioc.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

public class MyBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("helloBean")) {
            System.out.println(" -- 调用 BeanPostProcessor::postProcess[Before]Initialization ");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("helloBean")) {
            System.out.println("-- 调用 BeanPostProcessor::postProcess[After]Initialization ");
        }
        return bean;
    }

}
