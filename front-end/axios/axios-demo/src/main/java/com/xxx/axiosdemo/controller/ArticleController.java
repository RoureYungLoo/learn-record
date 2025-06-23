package com.xxx.axiosdemo.controller;

import com.xxx.axiosdemo.pojo.Article;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articles")
@CrossOrigin
public class ArticleController {
  private static List<Article> articleList = new ArrayList<>();

  {
    articleList.add(new Article(1L, "医疗反腐...", List.of("时事"), "2023-09", "已发布", "cat1.jpg", LocalDateTime.now(), LocalDateTime.now()));
    articleList.add(new Article(2L, "山东车祸...", List.of("时事"), "2023-09", "草稿", "cat2.jpg", LocalDateTime.now(), LocalDateTime.now()));
    articleList.add(new Article(3L, "月黑风高的夜晚...", List.of("小说"), "2023-09", "草稿", "cat5.jpg", LocalDateTime.now(), LocalDateTime.now()));
    articleList.add(new Article(4L, "杀死一只知更鸟是...", List.of("小说"), "2023-09", "草稿", "cat9.jpg", LocalDateTime.now(), LocalDateTime.now()));
    articleList.add(new Article(5L, "上海外滩...", List.of("旅游"), "2023-09", "已发布", "cat12.jpg", LocalDateTime.now(), LocalDateTime.now()));
    articleList.add(new Article(6L, "北京天安门...", List.of("旅游"), "2023-09", "草稿", "cat15.jpg", LocalDateTime.now(), LocalDateTime.now()));
  }

  @PostMapping("/add")
  public String add(@RequestBody Article article) {
    System.out.println(article);
    article.setId(articleList.size() + 1L);
    article.setUpdateTime(LocalDateTime.now());
    article.setCreateTime(LocalDateTime.now());
    articleList.add(article);
    return "success";
  }

  @GetMapping
  public List<Article> getAll() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
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
  public String update(@RequestBody Article article) {
    System.out.println(article);
    article.setId(articleList.size() + 1L);
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
    if ((category == null || category.equals("")) && state != null && !state.equals("")) {
      return articleList.stream().filter(a -> a.getState().equals(state)).collect(Collectors.toList());
    }
    return null;
  }

  @GetMapping("/{id}")
  public Article findById(@PathVariable("id") Long id) {
    return articleList.stream().filter(article -> article.getId().equals(id)).findFirst().orElse(null);
  }
}
