package com.xxx.mapper;

import com.mysql.cj.Session;
import com.xxx.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {

    private static UserMapper userMapper = null;

    static {
        String config = "mybatis-config.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        userMapper = sessionFactory.openSession(true).getMapper(UserMapper.class);
    }

    @Test
    public void testSelect() throws IOException {

        String username = "lisi";
        String password = "123456";

        User user = userMapper.select(username, password);

        System.out.println(user);

    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(4);
        System.out.println(user);
    }

    @Test
    public void testAddUser() {
        List<User> users = new ArrayList<>();
        users.add(new User(null, "曹操", "123456", "男", "郑州"));
        users.add(new User(null, "张飞", "123456", "男", "郑州"));
        users.add(new User(null, "刘备", "123456", "男", "郑州"));
        users.add(new User(null, "赵云", "123456", "男", "郑州"));
        users.add(new User(null, "周瑜", "123456", "男", "郑州"));
        for (User user :
                users) {
            int added = userMapper.addUser(user);
            System.out.println(added);
        }
    }

    @Test
    public void testUpdate(){
        int id = 8;
        User user = userMapper.selectById(id);
        user.setPassword("654321");
        user.setUsername("zhaoyun");

        int update = userMapper.update(user);
        System.out.println(update);
    }

    @Test
    public void testDelete(){
        int id = 9 ;
        int delete = userMapper.delete(id);
        System.out.println(delete);
    }

}
