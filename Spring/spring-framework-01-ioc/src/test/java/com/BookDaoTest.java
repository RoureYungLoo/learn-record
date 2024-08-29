package com;

import com.xxx.config.SpringConfiguration;
import com.xxx.dao.BookDao;
import com.xxx.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.format.FormatterRegistrar;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jws.WebResult;
import java.awt.print.PrinterAbortException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})

public class BookDaoTest {

    @Resource(name = "bookDaoImpl1")
    private BookDao bookDao;

    @Test
    public void testFindAll() {
        List<Book> all = bookDao.findAll();
        for (Book book : all) {
            System.out.println(book.getName());
        }
        System.out.println("test bookDao");
    }

}
