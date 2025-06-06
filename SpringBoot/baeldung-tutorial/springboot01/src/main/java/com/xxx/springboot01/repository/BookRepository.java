package com.xxx.springboot01.repository;

import com.xxx.springboot01.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository  extends CrudRepository<Book,Long> {
    List<Book> findByTitle(String title);
}
