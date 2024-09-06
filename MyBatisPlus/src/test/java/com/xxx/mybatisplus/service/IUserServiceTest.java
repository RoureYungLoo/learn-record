package com.xxx.mybatisplus.service;

import com.xxx.mybatisplus.domain.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IUserServiceTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void testSaveUser() {
        User user = new User();
        // user.setId(1L);
        user.setUsername("曹操");
        user.setPassword("123123");
        user.setPhone("12341234188");
        user.setInfo("{\"name\":\"caocao\",\"age\":55}");
        user.setStatus(1);
        user.setBalance(8000);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        // 调用service接口
        boolean save = iUserService.save(user);
        System.out.println(save);
    }

    @Test
    public void testQuery() {
        iUserService.listByIds(List.of(1, 2, 5)).forEach(System.out::println);
    }

    public User genUser(int i) {
        User user = new User();
        user.setUsername("user_" + i);
        user.setPassword("123456");
        user.setPhone(String.valueOf(18800000000L + Long.valueOf(i)));
        user.setInfo("{\"name\":\"用户名\",\"age\":33}");
        user.setStatus(1);
        user.setBalance(10000);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        return user;
    }

    @Test
    public void saveOneByOne() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            iUserService.save(genUser(i));
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - begin));
    }

    @Test
    public void testSaveByPatch() {
        List<User> users = new ArrayList<>(3000);
        long begin = System.currentTimeMillis();

        for (int i = 0; i <= 200000; i++) {
            users.add(genUser(i));
            if (i % 3000 == 0) {
                iUserService.saveBatch(users); // 每次一万条sql语句
                users.clear();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - begin));
    }
}