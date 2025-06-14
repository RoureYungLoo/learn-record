package com.randolflu.springframework03aop;

import com.randolflu.springframework03aop.aspectj2.AspectJ2Application;
import com.randolflu.springframework03aop.aspectj2.GoodBye;
import com.randolflu.springframework03aop.aspectj2.Hello;
import com.randolflu.springframework03aop.aspectj2.SayAspect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = AspectJ2Application.class)
//@SpringJUnitConfig(AspectJ2Application.class)
class SpringFramework03AopApplicationTests {

    @Test
    @DisplayName("contextLoads")
    void contextLoads() {
        System.out.println("");
    }

    @Autowired
    private Hello hello;
    @Autowired
    private SayAspect sayAspect;

    @BeforeEach
    public void reset(){
        assertNotNull(hello);
        assertNotNull(sayAspect);
        sayAspect.reset();
    }

    @Test
    @DisplayName("检查beans")
    public void testNotEmpty(){
        assertNotNull(hello);
        assertNotNull(sayAspect);
    }

    @Test
    @DisplayName("springHello是否为GoodBye类型")
    public void testIntroduction() {
        assertTrue(hello instanceof GoodBye);
    }

    @Test
    @DisplayName("通知是否均已执行")
    public void testAdvice() {
        StringBuffer words = new StringBuffer("Test. ");
        String sentence = hello.sayHello(words);
        assertEquals("Test. Welcome to Spring! [1]\n", words.toString());
        assertEquals("Hello! Test. Welcome to Spring! [1]\nBye! ", sentence);
    }

    @Test
    @DisplayName("说两句话，检查计数")
    public void testMultipleSpeaking() {
        assertEquals("Hello! Test. Welcome to Spring! [1]\nBye! ",
                hello.sayHello(new StringBuffer("Test. ")));
        assertEquals("Hello! Test. Welcome to Spring! [2]\nBye! ",
                hello.sayHello(new StringBuffer("Test. ")));
    }
}
