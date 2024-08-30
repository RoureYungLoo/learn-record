package com.randolflu.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.randolflu.constants.Expiration;
import org.apache.el.parser.Token;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class EncryptUtils {

    /* md5 */
    public static String MD5(String raw) {
        String hex = DigestUtils.md5DigestAsHex((raw).getBytes());
        String uuid = "UUID.randomUUID().toString()"; // 是否加盐？加盐怎么验证用户登录？
        String digest = DigestUtils.md5DigestAsHex((hex + uuid).getBytes());
        return digest;
    }

    /* jwt encode */
    public static String JWTEncode(Map<String, Object> claims, String key) {
        String token = JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(Expiration.ADay))
                .sign(Algorithm.HMAC256(key));
        return token;
    }

    /* jwt decode */
    public static Map<String, Object> JWTDecode(String token, String key) {
        Claim claims = JWT.require(Algorithm.HMAC256(key))
                .build()
                .verify(token)
                .getClaims()
                .get("claims");
        return claims.asMap();
    }
}
