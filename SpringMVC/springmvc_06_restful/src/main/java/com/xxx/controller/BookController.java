package com.xxx.controller;

import com.xxx.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/books")
public class BookController {
    /* 添加图书*/
    @PostMapping
    public String save(@RequestBody Book book) {
        System.out.println("books save ..." + book);
        return "{\"module\":\"book save\"}";
    }

    /* 修改图书*/
    @PutMapping
    public String update(@RequestBody Book book) {
        System.out.println("books update..." + book);
        return "{\"module\":\"book update\"}";
    }

    /* 删除图书*/
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        System.out.println("books delete ..." + id);
        return "{\"module\":\"book delete\"}";
    }

    /* 查询单个图书*/
    @GetMapping("/{id}")
    public String getById(@PathVariable String id) {
        System.out.println("books getById ..." + id);
        return "{\"module\":\"book getById \"}";
    }

    /* 查询所有图书*/
    @GetMapping
    public String getAll() {
        System.out.println("books getAll...");
        return "{\"module\":\"book getAll \"}";
    }

    /*=============================================================*/
//    /* 添加图书*/
//    // @RequestMapping(method = {RequestMethod.POST})
//    @PostMapping
//    public String save(@RequestBody Book book) {
//        System.out.println("books save ..." + book);
//        return "{\"module\":\"book save\"}";
//    }
//
//    /* 修改图书*/
//    // @RequestMapping(method = {RequestMethod.PUT})
//    @PutMapping
//    public String update(@RequestBody Book book) {
//        System.out.println("books update..." + book);
//        return "{\"module\":\"book update\"}";
//    }
//
//    /* 删除图书*/
//    // questMapping(value = "/{id}", method = {RequestMethod.DELETE})
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable String id) {
//        System.out.println("books delete ..." + id);
//        return "{\"module\":\"book delete\"}";
//    }
//
//    /* 查询单个图书*/
//    // @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
//    @GetMapping("/{id}")
//    public String getById(@PathVariable String id) {
//        System.out.println("books getById ..." + id);
//        return "{\"module\":\"book getById \"}";
//    }
//
//    /* 查询所有图书*/
//    // @RequestMapping(method = {RequestMethod.GET})
//    @GetMapping
//    public String getAll() {
//        System.out.println("books getAll...");
//        return "{\"module\":\"book getAll \"}";
//    }/*

    /* =================================================================
=*/

    /* 添加图书*//*
    @RequestMapping(value = "/books", method = {RequestMethod.POST})
    @ResponseBody
    public String save(@RequestBody Book book) {
        System.out.println("books save ..." + book);
        return "{\"module\":\"book save\"}";
    }

    *//* 修改图书*//*
    @RequestMapping(value = "/books", method = {RequestMethod.PUT})
    @ResponseBody
    public String update(@RequestBody Book book) {
        System.out.println("books update..." + book);
        return "{\"module\":\"book update\"}";
    }

    *//* 删除图书*//*
    @RequestMapping(value = "/books/{id}", method = {RequestMethod.DELETE})
    @ResponseBody
    public String delete(@PathVariable String id) {
        System.out.println("books delete ..." + id);
        return "{\"module\":\"book delete\"}";
    }

    *//* 查询单个图书*//*
    @RequestMapping(value = "/books/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public String getById(@PathVariable String id) {
        System.out.println("books getById ..." + id);
        return "{\"module\":\"book getById \"}";
    }

    *//* 查询所有图书*//*
    @RequestMapping(value = "/books", method = {RequestMethod.GET})
    @ResponseBody
    public String getAll() {
        System.out.println("books getAll...");
        return "{\"module\":\"book getAll \"}";
    }*/
}
