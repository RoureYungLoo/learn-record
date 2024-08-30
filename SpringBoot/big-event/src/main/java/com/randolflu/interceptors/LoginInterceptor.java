
package com.randolflu.interceptors;


import com.randolflu.security.Keys;
import com.randolflu.utils.EncryptUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        assert token !=null :"no token";
        try {
            EncryptUtils.JWTDecode(token, Keys.JwtTestKey);
            return true; /* jwt 认证成功 */
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false; /* jwt 认证失败 */
        }
    }
}
