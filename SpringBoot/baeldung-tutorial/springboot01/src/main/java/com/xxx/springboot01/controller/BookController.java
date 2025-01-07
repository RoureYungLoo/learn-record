package com.xxx.springboot01.controller;

import com.xxx.springboot01.entity.Book;
import com.xxx.springboot01.exception.BookIdMismatchException;
import com.xxx.springboot01.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    /* 查询所有 */
    @GetMapping
    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

    /* 根据title查询 */
    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable("bookTitle") String title) {
        return bookRepository.findByTitle(title);
    }

    /* 根据id查询 */
    @GetMapping("/{id}")
    public Book findById(@PathVariable("id") Long id) {
        return bookRepository.findById(id).get();
    }

    /* 新增一个 */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    /* 根据ID删除 */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        bookRepository.findById(id);
        bookRepository.deleteById(id);
    }

    /* 更新一个 */
    @PutMapping("/{id}")
    public Book updateById(@PathVariable("id") Long id, @RequestBody Book book) {
        if (book.getId() != id) {
            throw new BookIdMismatchException("id not match",new Throwable());
        }
        bookRepository.findById(id);
        return bookRepository.save(book);
    }

}
