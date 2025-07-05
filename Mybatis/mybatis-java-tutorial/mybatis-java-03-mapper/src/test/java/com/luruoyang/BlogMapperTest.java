package com.luruoyang;

import com.luruoyang.entity.Blog;
import com.luruoyang.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;


public class BlogMapperTest {
  private static SqlSession sqlSession;

  static {
    InputStream stream = null;
    try {
      stream = Resources.getResourceAsStream("mybatis-config.xml");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
    sqlSession = sqlSessionFactory.openSession();
  }

  @Test
  public void testSelectBlogDetails() {
    BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
    Blog blog = blogMapper.selectBlogDetails(1L);
    System.out.println(blog);
  }
}
