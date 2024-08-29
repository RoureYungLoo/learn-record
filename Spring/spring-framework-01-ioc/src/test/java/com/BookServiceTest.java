package com;

import com.xxx.config.Config3;
import com.xxx.config.SpringConfiguration;
import com.xxx.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config3.class})

public class BookServiceTest {

    @Resource
    private BookService bookService;

    @Test
    public void testBookService2(){
        System.out.println(bookService);
    }
}
