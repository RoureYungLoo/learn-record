package com.randolflu.service.impl;

import com.randolflu.mapper.CategoryMapper;
import com.randolflu.pojo.Category;
import com.randolflu.pojo.User;
import com.randolflu.service.CategoryService;
import com.randolflu.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /* 新增文章分类 */
    @Override
    public boolean add(Category category) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        category.setCreatedUser(userId);
        return categoryMapper.add(category) > 0;
    }

    /* 获取文章分类列表 */
    @Override
    public List<Category> getAll() {
        List<Category> categories = categoryMapper.getAll();
        return categories;
    }

    /* 获取当前用户的文章分类列表 */
    @Override
    public List<Category> getAllByCreatedUserId() {
        Integer createdUserId = ThreadLocalUtil.getThreadLocal("id");
        List<Category> categories = categoryMapper.getAllByUserId(createdUserId);
        return categories;
    }

    @Override
    public Category getById(Integer categoryId) {
        /* 防止小人: 小心有心人查询别人的文章分类 */
        Integer UserId = ThreadLocalUtil.getThreadLocal("id");

        Category category = categoryMapper.getById(categoryId, UserId);
        return category;
    }

    /* 更新文章分类 */
    @Override
    public boolean update(Category category) {
        /*当前登录用户ID*/
        Integer userId = ThreadLocalUtil.getThreadLocal("id");

        /* 不能更新别人的数据：根据前端传递过来的categoryId 和当前登录的用户id查询*/
        Category byIds = categoryMapper.getById(category.getId(), userId);
        if (byIds != null) {
            category.setCreatedUser(userId);
            category.setUpdatedTime(new Date());
            return categoryMapper.update(category) > 0;
        } else {
            return false;
        }
    }

    /* 删除文章分类 */
    public boolean delete(Integer categoryId) {
        Integer userId = ThreadLocalUtil.getThreadLocal("id");
        return categoryMapper.delete(userId, categoryId) > 0;
    }
}
