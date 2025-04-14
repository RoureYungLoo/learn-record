package com.randolflu.demomybatisplus01;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import com.randolflu.demomybatisplus01.domain.User;
import com.randolflu.demomybatisplus01.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoMybatisPlus01ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void select() {
        List<User> users = userMapper.selectList(null);
        System.out.println("users.size(): " + users.size());
        users.forEach((user) -> {
            System.out.println(user);
        });
    }

    @Test
    public void insert() {
        User user = new User();
        user.setName("小灰");
        user.setAge(20);
        user.setEmail("1980757771@qq.com");
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(new Date());
        int rows = userMapper.insert(user);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(1094592041087729666L);
        System.out.println(user);
    }

    @Test
    public void selectBatchIds() {
        List<Long> ids = Arrays.asList(1088250446457389058L, 1094590409767661570L, 1094592041087729666L);

        List<User> users = userMapper.selectBatchIds(ids);

        users.forEach(System.out::println);
    }

    @Test
    public void selectByMap() {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("age" /* 表字段名 */, 20);

        List<User> users = userMapper.selectByMap(userMap);

        users.forEach(System.out::println);
    }

    @Test
    public void selectList() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "猪")
                .lt("age", 40);

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "猪")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList3() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "小")

                .ge("age", 21)
                .orderByAsc("age")
                .orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList4() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d') - '2019-01-11' or true or true").inSql("manager_id", "select id from user where name like '猪%'");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList5() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "小")
                .and(wq -> wq.lt("age", 40))
                .or().isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


    @Test
    public void selectList6() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "小")
                .or(wq -> wq.lt("age", 30))
                .gt("age", 20)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList7() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "小")
                .nested(wq -> wq.lt("age", 40).or().isNotNull("email"))
                .likeRight("name", "小");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList8() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age", Arrays.asList(18, 19, 20));
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


    @Test
    public void selectList9() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age", Arrays.asList(18, 19, 20)).last("limit 1"); // 有SQL注入风险
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList10() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name").like("name", "猪").lt("age", 30);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList11() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name").like("name", "猪").lt("age", 30)
                .select(User.class, info -> !info.getColumn().equals("create_time") && !info.getColumn().equals("manager_id"));
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testCondition() {

        String name = "小";
        String email = "";

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        if (StringUtils.isNotEmpty(name)) {
//            queryWrapper.like("name", name);
//        }
//        if (StringUtils.isNotEmpty(email)) {
//            queryWrapper.like("email", email);
//        }

        queryWrapper.like(StringUtils.isNotEmpty(name), "name", name)
                .like(StringUtils.isNotEmpty(email), "email", email);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    @Test
    public void selectList12() {
        /* 这里创建一个 User 实体 */
        User whereUser = new User();
        whereUser.setName("小懒猪");
        whereUser.setAge(20);

//        QueryWrapper<User> queryWrapper = new QueryWrapper<>(); // SELECT id,name,age,email,manager_id,create_time FROM user WHERE (name LIKE ? AND age < ?)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(whereUser); //SELECT id,name,age,email,manager_id,create_time FROM user WHERE name LIKE CONCAT('%',?,'%') AND age<? AND (name LIKE ? AND age < ?)

        queryWrapper.like("name", "猪").lt("age", 40);

        List<User> users = userMapper.selectList(queryWrapper);


        users.forEach(System.out::println);
    }

    @Test
    public void testAllEq() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String, Object> params = new HashMap<>();
        params.put("name", "小懒猪");
        params.put("age", null);
//        queryWrapper.allEq(params, false); // SELECT id,name,age,email,manager_id,create_time FROM user WHERE (name = ?)
        queryWrapper.allEq((k, v) -> !k.equals("name")/* filter */, params); // SELECT id,name,age,email,manager_id,create_time FROM user WHERE (age IS NULL)
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


}
