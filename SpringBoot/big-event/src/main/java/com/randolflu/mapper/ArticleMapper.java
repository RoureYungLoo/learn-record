package com.randolflu.mapper;

import com.randolflu.pojo.Article;
import com.randolflu.pojo.Result;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    /* 添加文章 */
    @Insert("insert into article " +
            "(title,content,cover_img,state,category_id,created_user,created_time,updated_time) " +
            "values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createdUser},#{createdTime},#{updatedTime})")
    int add(Article article);

    List<Article> list(Integer userId, Integer categoryId, String state);

    @Delete("delete from article where id = #{id} and created_user=#{userId}")
    int delete(Integer userId, Integer id);

    @Update("update article set " +
            "title=#{title}," +
            "content=#{content}," +
            "cover_img=#{coverImg}," +
            "state=#{state}," +
            "category_id=#{categoryId}," +
            "updated_time=now() " +
            "where id = #{id} and created_user=#{createdUser}")
    int update(Article article);

    @Select("select * from article where id =#{id} and created_user=#{userId}")
    Article getById(Integer id, Integer userId);
}
