package com.luruoyang;


import com.luruoyang.entity.User;
import com.luruoyang.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest {
  private static SqlSession sqlSession;

  static {
    InputStream stream = null;
    try {
      stream = Resources.getResourceAsStream("mybatis-config.xml");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
    sqlSession = sqlSessionFactory.openSession(true);
  }

  @ParameterizedTest
  @ValueSource(longs = {1001, 1002, 1003})
  public void testFindUserById(Long userId) {
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    User userById = userMapper.findUserById(userId);
    System.out.println(userById);
  }
}
