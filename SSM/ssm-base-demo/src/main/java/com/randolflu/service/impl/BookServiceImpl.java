package com.randolflu.service.impl;

import com.randolflu.controller.Code;
import com.randolflu.domain.Book;
import com.randolflu.exception.BusinessException;
import com.randolflu.exception.SystemException;
import com.randolflu.mapper.BookMapper;
import com.randolflu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean save(Book book) {
        return bookMapper.save(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookMapper.update(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookMapper.delete(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        if (id == 1) {
            throw new BusinessException(Code.BUSINESS_ERR_XXX1, "用户非法输入");
        }

        // 将可能出现的异常包装，转换成自定义异常
//        try {
//            int i = 1 / 0;
//        } catch (Exception e) {
//            throw new SystemException(Code.SYSTEM_ERR_XXX1, "系统异常", e);
//        }

        return bookMapper.getById(id);
    }

//    @Override
//    public Book getById(Integer id) {
//        return bookMapper.getById(id);
//    }

    @Override
    public List<Book> getAll() {
        return bookMapper.getAll();
    }
}
