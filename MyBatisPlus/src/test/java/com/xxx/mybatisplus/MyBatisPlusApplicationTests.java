package com.xxx.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.xxx.mybatisplus.domain.po.User;
import com.xxx.mybatisplus.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest(classes = MyBatisPlusApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)

class MyBatisPlusApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);

    }


}
