package com.randolflu.mapper;

import com.randolflu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /* 根据用户名查询 */
    @Select("select * from user where username = #{username}")
    User findByUserName(String username);

    /* 添加用户 */
    @Insert("insert into user(username,password,created_time,updated_time) " +
            "values(#{username},#{password},now(),now())")
    int add(String username, String password);
}
