package org.xxx;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xxx.beans.BeanA;
import org.xxx.proxy.CGLIBProxy;
import org.xxx.proxy.JdkProxySubject;
import org.xxx.service.OrderService;
import org.xxx.service.UserService;
import org.xxx.service.impl.OrderServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Hello world!
 */
public class BaseProjectApp {
    public static void main(String[] args) {
/*        System.out.println("Hello World!");
        OrderServiceImpl realSubject = new OrderServiceImpl();

        // 获取 InvocationHandler 对象，在构造方法中注入目标对象
        InvocationHandler handler = new JdkProxySubject(realSubject);

        // 获取代理类对象
        OrderService proxyInstance = (OrderService) Proxy.newProxyInstance(BaseProjectApp.class.getClassLoader()
                , new Class[]{OrderService.class}
                , handler);

        // 调用目标方法
        proxyInstance.findAll();*/


//        OrderService target = new OrderServiceImpl();
//        CGLIBProxy callback = new CGLIBProxy(target);
//        OrderService proxyInstance = (OrderService) Enhancer.create(target.getClass(), callback);
//        proxyInstance.findAll();

//        UserService target = new UserService();
//        CGLIBProxy callback = new CGLIBProxy(target);
//        UserService proxyInstance = (UserService) Enhancer.create(target.getClass(), callback);
//        proxyInstance.findAll();

//        System.out.println("hello");
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        context.getBean(BeanA.class);

    }
}
