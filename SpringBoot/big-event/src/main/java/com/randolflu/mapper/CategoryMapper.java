package com.randolflu.mapper;

import com.randolflu.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("insert into category(category_name,category_alias,created_user,created_time,updated_time) " +
            "values(#{categoryName},#{categoryAlias},#{createdUser},now(),now())")
    int add(Category category);

    @Select("select * from category")
    List<Category> getAll();

    @Select("select * from category where created_user=#{uid}")
    List<Category> getAllByUserId(Integer uid);

    /* 根据分类id和用户id查询 */
    @Select("select  * from category where id = #{categoryId} and created_user = #{userId}")
    Category getById(Integer categoryId, Integer userId);

    @Update("update category set " +
            "category_name=#{categoryName}," +
            "category_alias=#{categoryAlias}," +
            "updated_time=#{updatedTime} " +
            "where id= #{id} and created_user=#{createdUser}")
    int update(Category category);
}
