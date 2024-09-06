package com.xxx.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xxx.mybatisplus.domain.po.User;
import com.xxx.mybatisplus.mapper.UserMapper;
import jakarta.annotation.Resource;
import jdk.jshell.execution.LoaderDelegate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.DateTimeException;
import java.util.List;

@SpringBootTest()
class MyBatisPlusApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void testSelectList() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }


    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testQueryWrapper() {
        /* 1. 构造查询条件*/
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "username", "info", "balance")
                .like("username", "o")
                .ge("balance", 100);

        /* 2. 查询 */
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testQueryWrapper2() {

        // 1. 要更新的数据
        User user = new User();
//        user.setId(1L);
//        user.setUsername("luruoyangnew");
//        user.setPassword("qwer1234");
//        user.setPhone("12341234188");
//        user.setInfo("{new info}");
//        user.setStatus(1);
        user.setBalance(4399);

        // 2. 更新条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","luruoyang");

        // 3. 执行更新
        int update = userMapper.update(user,queryWrapper);
        System.out.println(update);
    }

    /* UpdateWrapper */
    @Test
    public void testUpdateWrapper(){

        List<Long> ids = List.of(1L, 2L, 4L);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();

        updateWrapper.setSql("balance = balance - 200");
//        updateWrapper.in("id",List.of(1L,2L,4L));
        updateWrapper.in("id",ids);

        userMapper.update(null,updateWrapper);

    }

    /* LambdaWrapper */
    @Test
    public void testLambdaWrapper(){

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(User::getId,User::getUsername,User::getInfo,User::getBalance);
        lambdaQueryWrapper.like(User::getUsername,"o");
        lambdaQueryWrapper.ge(User::getBalance,2000);

        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(System.out::println);

    }

    /* 自定义SQL */
    @Test
    public void testCustomSQL(){

        List<Long> ids = List.of(1L,2L,4L);

        /* 1. 构建条件 */
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        int amount =200;
        lambdaQueryWrapper.in(User::getId,ids);

        /* 2. 自定义SQL方法调用 */
        userMapper.updateBalanceById(lambdaQueryWrapper,amount);
    }
}
