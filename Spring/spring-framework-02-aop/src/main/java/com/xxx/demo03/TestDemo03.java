package com.xxx.demo03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class TestDemo03 {


    @Resource
    private UserService userService;

    @Test
    public void test03(){
        System.out.println(userService);

        userService.saveUser();

        // int a=1/0;

        userService.updateUser();
    }
}
