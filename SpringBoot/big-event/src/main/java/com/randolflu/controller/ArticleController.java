package com.randolflu.controller;

import com.randolflu.pojo.Result;
import com.randolflu.security.Keys;
import com.randolflu.utils.EncryptUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public Result getAll(@RequestHeader("Authorization") String token , HttpServletResponse response){
        System.out.println("--");
//        try {
//            /* jwt 认证成功 */
//            EncryptUtils.JWTDecode(token, Keys.JwtTestKey);
//            return Result.success("所有文章内容.....");
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            return Result.error(e.getMessage());
//        }

         return Result.success("所有文章内容.....");
    }
}
