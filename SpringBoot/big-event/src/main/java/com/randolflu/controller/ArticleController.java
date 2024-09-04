package com.randolflu.controller;

import com.randolflu.pojo.Article;
import com.randolflu.pojo.PageBean;
import com.randolflu.pojo.Result;
import com.randolflu.security.Keys;
import com.randolflu.service.ArticleService;
import com.randolflu.utils.EncryptUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public Result getAll(@RequestHeader("Authorization") String token, HttpServletResponse response) {
        System.out.println("--");
        // try {
        //     /* jwt 认证成功 */
        //     EncryptUtils.JWTDecode(token, Keys.JwtTestKey);
        //     return Result.success("所有文章内容.....");
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     response.setStatus(HttpStatus.UNAUTHORIZED.value());
        //     return Result.error(e.getMessage());
        // }

        return Result.success("所有文章内容.....");
    }

    /* 添加文章 */
    @PostMapping
    public Result add(@RequestBody @Validated Article article) {
        if (articleService.add(article)) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    /* 文章查询，条件查询分页 */
    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
        PageBean<Article> pageBean = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(pageBean);
    }

    /* 删除文章 */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        if (articleService.delete(id)) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    /* 更新文章 */
    @PutMapping
    public Result update(@RequestBody @Validated Article article) {
        if (articleService.update(article)) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    /* 获取文章详情 */
    @GetMapping("/{id}")
    public Result<Article> getById(@PathVariable("id") Integer id) {

        return Result.success(articleService.getById(id));
    }
}
