package com.xxx.dao;

import com.xxx.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookDao {
    public List<Book> findAll();
}
