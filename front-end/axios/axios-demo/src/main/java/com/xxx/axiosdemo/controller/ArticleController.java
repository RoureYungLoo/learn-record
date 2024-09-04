package com.xxx.axiosdemo.controller;

import com.xxx.axiosdemo.pojo.Article;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    private static List<Article> articleList = new ArrayList<>();

    {
        articleList.add(new Article(1, "医疗反腐...", "时事", "2023-09", "已发布"));
        articleList.add(new Article(2, "山东车祸...", "时事", "2023-09", "草稿"));
        articleList.add(new Article(3, "月黑风高的夜晚...", "小说", "2023-09", "草稿"));
        articleList.add(new Article(4, "杀死一只知更鸟是...", "小说", "2023-09", "草稿"));
        articleList.add(new Article(5, "上海外滩...", "旅游", "2023-09", "已发布"));
        articleList.add(new Article(6, "北京天安门...", "旅游", "2023-09", "草稿"));
    }

    @PostMapping("/add")
    public String add(@RequestBody Article article) {
        articleList.add(article);
        return "新增成功";
    }

    @GetMapping("/getAll")
    public List<Article> getAll() {
        return articleList;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if (articleList.removeIf(e -> Objects.equals(e.getId(), id))) {
            return "删除成功, id为" + id;
        } else {
            return "删除失败, id为" + id;
        }

    }

    /* 修改 */
    @PutMapping
    public String update(@RequestBody Article article){
        System.out.println(article);
        article.setId(articleList.size()+1);
        articleList.add(article);
        return "更新成功";
    }

    @GetMapping("/search")
    public List<Article> search(String category, String state) {
        System.out.println("category: " + category);
        System.out.println("state: " + state);
        if (category != null && !category.equals("") && state != null && !state.equals("")) {
            return articleList.stream().filter(a -> a.getCategory().equals(category) && a.getState().equals(state)).collect(Collectors.toList());
        }
        if (category != null && !category.equals("") && state == null || state.equals("")) {
            return articleList.stream().filter(a -> a.getCategory().equals(category)).collect(Collectors.toList());
        }
        if ((category == null||category.equals("")) && state != null && !state.equals("")) {
            return articleList.stream().filter(a -> a.getState().equals(state)).collect(Collectors.toList());
        }
        return null;
    }
}
