package com.randolflu.springframework02ioc.applications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFramework02IocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFramework02IocApplication.class, args);

        /* 传统手动方式 new 对象 */
        /*Hello hello = new Hello();
        System.out.println(hello.getHelloStr());
        System.out.println(hello);*/

        /* 从spring容器中获取对象 */
        /*BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:beans.xml");
        Object bean = beanFactory.getBean("helloBean");
        Hello helloBean = (Hello) bean;
        String str = helloBean.getHelloStr();
        System.out.println(str);*/

        /* 从spring容器中获取对象 */
        /*BeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) beanFactory);
        reader.loadBeanDefinitions("classpath:beans.xml");
        Object bean = beanFactory.getBean("helloBean");
        Hello helloBean = (Hello) bean;
        System.out.println(helloBean.getHelloStr());*/



    }

}
