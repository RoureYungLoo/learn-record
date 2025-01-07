package com.randolflu.service;

import com.randolflu.pojo.Category;

import java.util.List;

public interface CategoryService {
    boolean add(Category category);

    /* 所有用户的所有分类 */
    List<Category> getAll();


//    List<Category> getAll(Integer userId);

    /* 当前用户的所有分类 */
    List<Category> getAllByCreatedUserId();

    Category getById(Integer id);

    boolean update(Category category);

    boolean delete(Integer id);
}
