package com.luruoyang;

import com.luruoyang.entity.Blog;
import com.luruoyang.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test01 {
  public static void main(String[] args) throws Exception {
    InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    /* 通过sqlSession直接执行SQL */
    Object o = sqlSession.selectOne("com.luruoyang.mapper.BlogMapper.selectBlog", 10);
    System.out.println((Blog) o);

    /* 通过获取Mapper接口代理类, 执行接口方法 */
    BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
    Blog blog = mapper.selectBlog(11);
    System.out.println(blog);

    /*
    SqlSessionFactoryBuilder 最佳作用域: 方法作用域（也就是局部方法变量）
SqlSessionFactory 最佳作用域是应用作用域, 使用单例模式或者静态单例模式
SqlSession 非多线程安全, 最佳的作用域是请求或方法作用域
     */

    sqlSession.close();
  }
}
