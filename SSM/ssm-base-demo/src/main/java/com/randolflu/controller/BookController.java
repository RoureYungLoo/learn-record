package com.randolflu.controller;

import com.randolflu.domain.Book;
import com.randolflu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {

        boolean flag = bookService.save(book);
        if (flag) {
            return new Result(Code.SAVE_OK, flag,"添加成功");
        } else {
            return new Result(Code.SAVE_ERR, flag);
        }
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        System.out.println(book);
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "查询成功" : "查询失败";
        return new Result(code, book, msg);
    }

    @GetMapping
    public Result getAll() {
//        int i =1/0;
        List<Book> bookList = bookService.getAll();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bookList != null ? "success" : "查询失败";
        return new Result(code, bookList, msg);
    }

    /*====================[未封装交互协议的代码]=====================*/
//    @Autowired
//    private BookService bookService;
//
//    @PostMapping
//    public boolean save(@RequestBody Book book) {
//        return bookService.save(book);
//    }
//
//    @PutMapping
//    public boolean update(@RequestBody Book book) {
//
//        return bookService.update(book);
//    }
//
//    @DeleteMapping("/{id}")
//    public boolean delete(@PathVariable Integer id) {
//
//        return bookService.delete(id);
//    }
//
//    @GetMapping("/{id}")
//    public Book getById(@PathVariable Integer id) {
//        return bookService.getById(id);
//    }
//
//    @GetMapping
//    public List<Book> getAll() {
//        return bookService.getAll();
//    }
}
