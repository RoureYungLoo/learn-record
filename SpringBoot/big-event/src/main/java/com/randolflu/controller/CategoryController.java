package com.randolflu.controller;

import com.randolflu.pojo.Category;
import com.randolflu.pojo.Result;
import com.randolflu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
//@CrossOrigin

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /* 新增文章分类 */
    @PostMapping()
    public Result save(@RequestBody @Validated(Category.Add.class) Category category) {
        System.out.println(category);
        if (categoryService.add(category)) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    /* 获取分类列表 */
    @GetMapping
    public Result<List<Category>> getAll(){
        // List<Category> categories =  categoryService.getAll();
        List<Category> categories =  categoryService.getAllByCreatedUserId();
        return Result.success(categories);
    }

    /* 获取分类详情 */
    @GetMapping("/{id}")
    public Result<Category> getById(@PathVariable("id") Integer id){
        Category category= categoryService.getById(id);
        return Result.success(category);
    }

    /* 更新文章分类 */
    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category){
        if(categoryService.update(category)){
            return Result.success();
        }else {
            return Result.error();
        }
    }

}
