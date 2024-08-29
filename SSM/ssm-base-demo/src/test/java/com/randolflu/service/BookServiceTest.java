package com.randolflu.service;

import com.randolflu.config.SpringConfig;
import com.randolflu.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.ws.Service;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testSave() {
        boolean save = bookService.save(new Book(null, "红楼梦", "文学名著", "这是红楼梦的描述"));
        System.out.println(save);

    }

    @Test
    public void update() {
        Book book = bookService.getById(4);
        book.setName("《红楼梦》");
        boolean update = bookService.update(book);
        System.out.println(update);
    }

    @Test
    public void delete() {
        boolean delete = bookService.delete(4);
        System.out.println(delete);
    }

    @Test
    public void testGetById() {
        Book book = bookService.getById(1);
        System.out.println(book);
    }

    @Test
    public void testGetAll() {
        List<Book> books = bookService.getAll();
        System.out.println(books);
    }
}
