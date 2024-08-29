package com.xxx.mapper;

import com.xxx.entity.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    /*
     * 多个参数，会封装为map集合, @Param注解替换Map集合中默认的arg键名
     * map.put("arg0", 形参名1);
     * map.put("param1", 形参名1);
     * map.put("arg1", 形参名2);
     * map.put("param2", 形参名2);
     * */
    User select(String username, String password);
    // User select(@Param("username") String username, @Param("password") String password);

    /* 查询 */
    @Select(value = "select * from tb_user where id = #{id}")
    User selectById(int id);

    /* 增加 */
    @Insert("insert into tb_user (username,password,gender,addr) values(#{username},#{password},#{gender},#{addr})")
    int addUser(User user);

    /* 修改 */
    @Update("update tb_user set username=#{username},password=#{password},gender=#{gender},addr=#{addr} where id = #{id}")
    int update(User user);

    /* 删除 */
    @Delete("delete from tb_user where id = #{id}")
    int delete(int id);
}
