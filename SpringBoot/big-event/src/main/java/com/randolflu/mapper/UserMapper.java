package com.randolflu.mapper;

import com.randolflu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    /* 根据用户名查询 */
    @Select("select * from user where username = #{username}")
    User findByUserName(String username);

    /* 添加用户 */
    @Insert("insert into user(username,password,created_time,updated_time) " +
            "values(#{username},#{password},now(),now())")
    int add(String username, String password);

    @Update("update user set username = #{username}, email=#{email},updated_time=now() where id = #{id}")
    void update(User user);

    @Update("update user set user_pic=#{avatarUrl}, updated_time=now() where id=#{id} ")
    void updateAvatar(String avatarUrl, Integer id);

    @Update("update user set password=#{newPwd}, updated_time=now() where id=#{id}")
    int updatePwd(String newPwd, Integer id);
}
