package com.luruoyang.mapper;

import com.luruoyang.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  User findUserById(Long userId);
}
