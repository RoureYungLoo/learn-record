package com.xxx.service;

import com.xxx.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TeacherTest {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Teacher teacher = (Teacher) context.getBean("teacher");
        teacher.getDog().say();
        teacher.getPig().say();
        System.out.println(teacher.getStr());

        Teacher thr2 = (Teacher) context.getBean("thr2");
        thr2.getPig().say();
        thr2.getDog().say();
        System.out.println(thr2.getStr());

        Teacher thr3 = (Teacher) context.getBean("thr3");
        thr3.getPig().say();
        thr3.getDog().say();
        System.out.println(thr3.getStr());

    }
}
