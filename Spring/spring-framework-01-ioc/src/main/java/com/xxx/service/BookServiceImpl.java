package com.xxx.service;

import com.xxx.dao.BookDao;
import com.xxx.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//@Component("bookServiceImpl1") // 注入简单值
@Service("userServiceImpl1") // 注入简单值
public class BookServiceImpl implements BookService {

    // @Resource // 按照类型注入bookDao对象
    @Resource(name = "bookDaoImpl1") // 根据名称注入对象bookDao
    private BookDao bookDao;

    @Override
    public List<Book> findAll() {
        System.out.println("--11");
        List<Book> books = bookDao.findAll();
        System.out.println("--22");
        return books;
    }
}
