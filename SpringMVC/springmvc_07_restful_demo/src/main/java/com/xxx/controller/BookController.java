package com.xxx.controller;

import com.xxx.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    /* 添加图书*/
    @PostMapping
    public String save(@RequestBody Book book) {
        System.out.println("books save ..." + book);
        return "{\"module\":\"book save success\"}";
    }

    /* 查询所有图书*/
    @GetMapping
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Spring MVC 教程", "计算机技术", "这是一本关于SpringMVC的教程"));
        books.add(new Book(2, "Java 教程", "计算机技术", "这是一本关于Java的教程"));
        books.add(new Book(3, "Spring 教程", "计算机技术", "这是一本关于Spring的教程"));
        System.out.println("books getAll..." + books);
        return books;
    }

//    /* 修改图书*/
//    @PutMapping
//    public String update(@RequestBody Book book) {
//        System.out.println("books update..." + book);
//        return "{\"module\":\"book update\"}";
//    }
//
//    /* 删除图书*/
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable String id) {
//        System.out.println("books delete ..." + id);
//        return "{\"module\":\"book delete\"}";
//    }
//
//    /* 查询单个图书*/
//    @GetMapping("/{id}")
//    public String getById(@PathVariable String id) {
//        System.out.println("books getById ..." + id);
//        return "{\"module\":\"book getById \"}";
//    }


}
