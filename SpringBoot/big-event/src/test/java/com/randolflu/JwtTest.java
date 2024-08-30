package com.randolflu;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.randolflu.constants.Expiration;
import com.randolflu.security.Keys;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void getToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "lisi");
        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(Expiration.ADay))
                .sign(Algorithm.HMAC256(Keys.JwtTestKey));
        System.out.println(token);
    }

    @Test
    public void parseToken(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MjUxMDE2ODUsInVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoibGlzaSJ9fQ.WfaLXDFrK6CbjwBw-1LHsCLd4OjYCYg9PzPZ8mPva-Y";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(Keys.JwtTestKey)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
