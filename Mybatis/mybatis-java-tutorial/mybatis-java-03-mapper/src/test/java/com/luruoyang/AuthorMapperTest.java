package com.luruoyang;


import com.luruoyang.entity.Author;
import com.luruoyang.mapper.AuthorMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Logger;

public class AuthorMapperTest {

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
  public void testInsertAuthor() {
    Author author = Author.builder()
        .id(null)
        .username("lisi")
        .password("123456")
        .email("lisi@qq.com")
        .bio("fiapojdfiaosdfjawe").build();

    AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
    int id = authorMapper.insertAuthor(author);

    /* 在单元测试中会自动回滚 */
    sqlSession.commit();
    System.out.println(id);
    System.out.println(author);
  }

  @Test
  public void testUpdateAuthor() {
    Author author = Author.builder()
        .id(100)
        .username("张三111")
        .password("123456")
        .email("666@qq.com")
        .bio("biosdsddsds")
        .build();
    AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
    int updated = authorMapper.updateAuthor(author);
    sqlSession.commit();
    System.out.println(updated);
  }

  @Test
  public void testDeleteAuthor() {
    AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
    int deleted = authorMapper.deleteAuthor(106);
    System.out.println(deleted);
    sqlSession.commit();
  }

  @Test
  public void testInsertAuthorList() {
    List<Author> authorList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Integer integer = new Random().nextInt(0, 10000000);
      Author author = Author.builder()
          .bio("bio" + integer)
          .username("lisi" + integer)
          .password(integer.toString())
          .email(integer + "@qq.com")
          .build();
      authorList.add(author);
    }

    AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
    authorMapper.insertAuthors(authorList);
    sqlSession.commit();
  }

  @Test

  public void testSelectAuthorById() {
    AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
//    Author author = authorMapper.selectAuthorById(100);
    Map<String, Object> authorMap = authorMapper.selectAuthorById(100);
    Logger logger = Logger.getLogger("aaa");
    System.out.println(authorMap.toString());

    System.out.println("-------------------");
    Set<Map.Entry<String, Object>> entries = authorMap.entrySet();
    for (Map.Entry<String, Object> entry : entries) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }

    System.out.println("=========================");
    Set<String> set1 = authorMap.keySet();
    System.out.println(set1);
  }

  @Test
  public void testSqlFragsTableName() {
    AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
    Map<String, Object> map = authorMapper.sqlFragsTableName(111);
    System.out.println(map);
  }

  @Test
  public void testSelectById() {
    AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
    Author author = authorMapper.selectById(111);
    System.out.println(author);
  }

  @Test
  public void testFindByColumn() {
    AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
    Author author = authorMapper.findByColumn("name", "张三7");
    System.out.println(author);
    author = authorMapper.findByColumn("bio", "bio9628630");
    System.out.println(author);
  }

  @Test
  public void testFindByColumnWithResultTypeMap() {
    AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
    Map author = authorMapper.findByColumnWithResultTypeMap("name", "张三7");
    System.out.println(author.getClass());
    author = authorMapper.findByColumnWithResultTypeMap("bio", "bio9628630");
    System.out.println(author);
  }
}
