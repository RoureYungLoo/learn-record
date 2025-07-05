package com.luruoyang;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JjwtUtils {
    // 建议将密钥放到配置文件中，这里仅做演示
    private static final String SECRET = "mySuperSecretKeyForJwtDemo1234567890";
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());
    private static final long EXPIRATION = 1000 * 60 * 60; // 1小时

    /**
     * 生成JWT Token
     * @param claims 载荷内容
     * @return token字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 解析JWT Token
     * @param token token字符串
     * @return 载荷内容
     * @throws JwtException token无效或过期时抛出
     */
    public static Claims parseToken(String token) throws JwtException {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
} 