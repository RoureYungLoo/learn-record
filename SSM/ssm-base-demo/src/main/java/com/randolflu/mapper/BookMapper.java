package com.randolflu.mapper;

import com.randolflu.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookMapper {
    // @Insert()
    public int save(Book book);

    // @Update()
    public int update(Book book);

    // @Delete()
    public int delete(Integer id);

    // @Select()
    public Book getById(Integer id);

    // @Select()
    public List<Book> getAll();

}
