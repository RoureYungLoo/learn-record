package com.randolflu.service;

import com.randolflu.pojo.Article;
import com.randolflu.pojo.PageBean;
import com.randolflu.pojo.Result;

public interface ArticleService {

    /* 添加文章 */
    boolean add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    boolean delete(Integer id);

    boolean update(Article article);

    Article getById(Integer id);
}
