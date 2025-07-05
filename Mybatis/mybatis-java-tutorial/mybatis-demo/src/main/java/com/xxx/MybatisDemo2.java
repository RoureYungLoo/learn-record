package com.xxx;

import com.xxx.mapper.UserMapper;
import com.xxx.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sessionFactory.openSession();

        // 3. 执行 SQL语句
        // List<User> users = sqlSession.selectList("User.selectAll");

        // 3. 获取UserMapper的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();

        System.out.println(users);
        session.close();

    }
}
