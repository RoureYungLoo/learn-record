
package com.randolflu.interceptors;


import com.randolflu.security.Keys;
import com.randolflu.utils.EncryptUtils;
import com.randolflu.utils.RedisUtil;
import com.randolflu.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");
        System.out.println("token: "+token);
        assert token != null : "no token";
        try {
            Map<String, Object> claims = EncryptUtils.JWTDecode(token, Keys.JwtTestKey);
            ThreadLocalUtil.set(claims);  //存储到 ThreadLocal

             //从redis中获取key
            ValueOperations<String, String> redis = stringRedisTemplate.opsForValue();
            String key = RedisUtil.wrapKey("token", String.valueOf(ThreadLocalUtil.getThreadLocal("id"))); // "token:userid"
            String s = redis.get(key);
            System.out.println(key+":"+s);
            if (s == null) {
                throw new RuntimeException();
            }
            return true;  //jwt 认证成功
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;  //jwt 认证失败
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /* 资源释放 */
        ThreadLocalUtil.remove();
    }
}
