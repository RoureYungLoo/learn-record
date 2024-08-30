package com.randolflu.service.impl;

import com.randolflu.mapper.UserMapper;
import com.randolflu.pojo.User;
import com.randolflu.security.Keys;
import com.randolflu.service.UserService;
import com.randolflu.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }


    public int add(String username, String password) {
        // 密码加密
        int row = userMapper.add(username, EncryptUtils.MD5(password));
        return row;
    }

    /* 用户登录 */
    public String login(String username, String password) {
        User loginUser = userMapper.findByUserName(username);
        if (EncryptUtils.MD5(password).equals(loginUser.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = EncryptUtils.JWTEncode(claims, Keys.JwtTestKey);  // 重复登录问题？
            return token;
        }
        return null;
    }

    /* 获取用户信息 */
    public User getUserInfo(String token) {
        Map<String, Object> map = EncryptUtils.JWTDecode(token, Keys.JwtTestKey);
        String username = (String) map.get("username");
        User user = userMapper.findByUserName(username);
        return user;
    }
}
