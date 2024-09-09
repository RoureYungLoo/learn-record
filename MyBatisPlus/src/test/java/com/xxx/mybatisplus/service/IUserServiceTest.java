package com.xxx.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.mybatisplus.domain.po.User;
import com.xxx.mybatisplus.domain.po.UserInfo;
import com.xxx.mybatisplus.enums.UserStatus;
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
        //user.setInfo("{\"name\":\"caocao\",\"age\":55}");
        user.setInfo(UserInfo.of(55, "caocao", "male"));
        user.setStatus(UserStatus.NORMAL);
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
        // user.setInfo("{\"name\":\"用户名\",\"age\":33}");
        user.setInfo(UserInfo.of(33, "用户名", "male"));
        user.setStatus(UserStatus.NORMAL);
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

    @Test
    public void testPage() {
//        Page<User> page = new Page<>(2,3);

        Page<User> page = Page.of(2, 3);

        page.addOrder(new OrderItem().setColumn("balance").setAsc(true));

        Page<User> p = iUserService.page(page);

        System.out.println(p.getTotal()); // 总条数
        System.out.println(p.getPages()); // 总页数
        List<User> userList = p.getRecords(); // 分页数据
        userList.forEach(System.out::println);

    }
}