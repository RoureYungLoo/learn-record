package org.xxx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xxx.proxy.JdkProxySubject;
import org.xxx.service.OrderService;
import org.xxx.service.impl.OrderServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class AppTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void shouldAnswerWithTrue() {
        orderService.findAll();
    }

    @Test
    public void testJdkProxySubject(){


    }
}
