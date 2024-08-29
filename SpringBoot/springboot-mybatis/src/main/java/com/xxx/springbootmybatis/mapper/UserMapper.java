package com.xxx.springbootmybatis.mapper;

import com.xxx.springbootmybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from tb_user_boot where id = #{id}")
   public User findById(int id);
}
