package com.xxx.service;

import com.xxx.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService {
    public List<Book> findAll();
}
