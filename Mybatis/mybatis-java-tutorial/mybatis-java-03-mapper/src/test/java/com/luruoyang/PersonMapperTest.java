package com.luruoyang;


import com.luruoyang.entity.Author;
import com.luruoyang.entity.Person;
import com.luruoyang.mapper.AuthorMapper;
import com.luruoyang.mapper.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;


public class PersonMapperTest {
  private static SqlSession sqlSession;

  static {
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    sqlSession = sessionFactory.openSession();

  }

  @Test
  public void testSelect() {
    PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
    Person person = personMapper.selectPerson(1);
    System.out.println(person);
  }


}
