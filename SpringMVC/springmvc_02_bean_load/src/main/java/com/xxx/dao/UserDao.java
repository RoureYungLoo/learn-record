package com.xxx.dao;

import com.xxx.domain.User;
import org.apache.ibatis.annotations.Insert;

public interface UserDao {

    @Insert("insert into tbl_user(name,age) values (#{name},#{age}})")
    void save(User user);
}
