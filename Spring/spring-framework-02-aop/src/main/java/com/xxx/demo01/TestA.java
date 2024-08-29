package com.xxx.demo01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig01.class})

public class TestA {

    @Resource
    private User user;

    @Test
    public void test01(){
        user.eat();
    }

}
