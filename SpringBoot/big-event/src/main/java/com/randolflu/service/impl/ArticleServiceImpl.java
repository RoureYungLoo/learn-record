package com.randolflu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.randolflu.mapper.ArticleMapper;
import com.randolflu.mapper.CategoryMapper;
import com.randolflu.pojo.Article;
import com.randolflu.pojo.Category;
import com.randolflu.pojo.PageBean;
import com.randolflu.pojo.Result;
import com.randolflu.service.ArticleService;
import com.randolflu.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    /* 添加文章*/
    @Override
    public boolean add(Article article) {
        Integer userId = ThreadLocalUtil.getThreadLocal("id");
        article.setCreatedUser(userId);

        /* 不能添加到别人的分类 */
        Category category = categoryMapper.getById(article.getCategoryId(), userId);
        if (category == null) {
            return false;
        }

        // 服务器时间
        article.setCreatedTime(new Date());
        article.setUpdatedTime(new Date());

        return articleMapper.add(article) > 0;
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        /* 创建PageBean对象 */
        PageBean<Article> pageBean = new PageBean<>();

        /* 开启分页查询 */
        PageHelper.startPage(pageNum, pageSize);

        /* 调用mapper */
        Integer userId = ThreadLocalUtil.getThreadLocal("id");
        List<Article> articleList = articleMapper.list(userId, categoryId, state);

        /* Page中可以获取总记录数和当前页数据*/
        Page<Article> pageData = (Page<Article>) articleList;

        pageBean.setTotal(pageData.getTotal());
        pageBean.setItems(pageData.getResult());

        return pageBean;
    }

    /* 删除文章*/
    @Override
    public boolean delete(Integer id) {
        Integer userId = ThreadLocalUtil.getThreadLocal("id");

        return articleMapper.delete(userId, id) > 0;
    }

    /* 更新文章*/
    public boolean update(Article article) {
        Integer userId = ThreadLocalUtil.getThreadLocal("id");

        article.setCreatedUser(userId);

        /* 查询分类 */
        Integer categoryId = article.getCategoryId();
        Category category = categoryMapper.getById(categoryId, userId);
        if (category==null){
            return false;
        }

        return articleMapper.update(article) > 0;
    }

    /* 获取文章详情 */
    public Article getById(Integer id) {
        Integer userId = ThreadLocalUtil.getThreadLocal("id");

        return articleMapper.getById(id,userId);
    }
}
