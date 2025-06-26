package com.luruoyang.mapper;


import com.luruoyang.entity.Blog;
import org.apache.ibatis.annotations.Select;

public interface BlogMapper {
  Blog selectBlog(Integer blogId);

  /*通过注解定义SQL语句*/
  @Select("select * from tb_blog where id = #{blogId}")
  Blog selectBlogById(Integer blogId);

}
