package com.randolflu.service.impl;

import com.randolflu.mapper.UserMapper;
import com.randolflu.pojo.Result;
import com.randolflu.pojo.User;
import com.randolflu.security.Keys;
import com.randolflu.service.UserService;
import com.randolflu.utils.EncryptUtils;
import com.randolflu.utils.RedisUtil;
import com.randolflu.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
            claims.put("id", loginUser.getId());    // 用户ID存入ThreadLocal
            claims.put("username", loginUser.getUsername());
            String token = EncryptUtils.JWTEncode(claims, Keys.JwtTestKey);  // 重复登录问题？

            ValueOperations<String, String> redis = stringRedisTemplate.opsForValue();
            String key = RedisUtil.wrapKey("token",String.valueOf(loginUser.getId())); // "token:userid"
            redis.set(key,"1",30, TimeUnit.DAYS);
            return token;
            //return "登录成功";
        }
        return null;
    }

    /* 获取用户信息 */
    public User getUserInfo(String token) {
        // Map<String, Object> map = EncryptUtils.JWTDecode(token, Keys.JwtTestKey);
        // String username = (String) map.get("username");
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userMapper.findByUserName(username);
        return user;
    }

    /* 更新用户信息 */
    @Override
    public boolean update(User user) {
        return userMapper.update(user)>0;
    }

    @Override
    public boolean updatePwd(Map<String, String> params) {
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        /* 参数缺失校验 */
        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            return false;
        }

        /* 新密码不能和旧密码相同, 两次密码输入不一致 */
        if (newPwd.equals(oldPwd)|| !newPwd.equals(rePwd)) {
            return false;
        }

        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userMapper.findByUserName(username);

        /* 原密码是否正确 */
        if (!EncryptUtils.MD5(oldPwd).equals(loginUser.getPassword())) {
            return false;
        }

        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");

         //密码更新成功
        if (userMapper.updatePwd(EncryptUtils.MD5(newPwd), id)>0){
            String key = RedisUtil.wrapKey("token",String.valueOf(id));
            RedisOperations<String, String> redis = stringRedisTemplate.opsForValue().getOperations();
            Boolean b = redis.delete(key); // 用户需要重新登录
            if (b){
                System.out.println(key+"已失效");
            }
            return true;
        }

        return false;
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        // 从ThreadLocal获取 用户id
        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        userMapper.updateAvatar(avatarUrl, id);
    }
}
