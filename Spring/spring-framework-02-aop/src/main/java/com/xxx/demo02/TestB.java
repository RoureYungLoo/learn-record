package com.xxx.demo02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig2.class})

public class TestB {
    @Resource
    private UserService userService;

    @Test
    public void test02(){
        userService.addUser();

        System.out.println("--------------");

        userService.delUser();
    }
}
