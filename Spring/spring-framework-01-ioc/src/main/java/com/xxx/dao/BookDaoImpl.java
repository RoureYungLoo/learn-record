package com.xxx.dao;

import com.xxx.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Component("bookDaoImpl1")
@Repository("bookDaoImpl1")
public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("《Java核心技术卷》", 75.8));
        books.add(new Book("《Spring实战》", 35));
        books.add(new Book("《Redis实战》", 55));
        return books;
    }
}
