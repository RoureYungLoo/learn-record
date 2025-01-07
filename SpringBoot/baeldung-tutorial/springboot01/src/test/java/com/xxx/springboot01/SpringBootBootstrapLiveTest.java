package com.xxx.springboot01;


import com.xxx.springboot01.entity.Book;
import com.xxx.springboot01.exception.BookIdMismatchException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Random;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringBootBootstrapLiveTest {

    private static final String API_ROOT = "http://localhost:8081/api/books";

    private Book createRandomBook() {
        Book book = new Book();
        book.setTitle(StringUtils.randomAlphanumeric(10));
        book.setAuthor(StringUtils.randomAlphanumeric(15));
        return book;
    }

    private String createBookAsUri(Book book) {
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

    @Test
    public void whenGetAllBooks_thenOk() {
        Response response = RestAssured.get(API_ROOT);
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetBookByTitle_then_OK() {
        Book book = createRandomBook();
        createBookAsUri(book);
        Response response = RestAssured.get(API_ROOT + "/title/" + book.getTitle());
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        Assert.assertTrue(response.as(List.class).size() > 0);
    }

    @Test
    public void whenGetCreatedBookById_thenOK() {
        Book book = createRandomBook();
        String location = createBookAsUri(book);
        System.out.println(location);
        Response response = RestAssured.get(location);
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        Assert.assertEquals(book.getTitle(), response.jsonPath().get("title"));
    }

    @Test
    public void whenGetNotExistBookById_thenOK() {
        Response res = RestAssured.get(API_ROOT + "/" + RandomStringUtils.randomNumeric(4));
        System.out.println(res.getBody().prettyPrint());
        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), res.getStatusCode());
    }

    @Test
    public void whenCreateNewBook_thenCreated() {
        Book book = createRandomBook();
        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(book).post(API_ROOT);
        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void whenInvalidBook_thenError() {
        Book book = createRandomBook();
        book.setAuthor(null);
        Response post = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(book).post(API_ROOT);
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), post.getStatusCode());
    }

    @Test
    public void whenUpdateCreatedBook_thenUpdated() {
        Book book = createRandomBook();
        String location = createBookAsUri(book);
//        book.setId(1L);
        book.setId(Long.parseLong(location.split("api/books/")[1]));
        book.setAuthor("吴承恩");

        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(book).put(location);

        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        Response response1 = RestAssured.get(location);
        Assert.assertEquals(HttpStatus.OK.value(), response1.getStatusCode());
        Assert.assertEquals("吴承恩", response1.jsonPath().get("author"));
    }

    @Test
    public void whenDeleteCreatedBook_thenOK() {
        Book book = createRandomBook();
        String location = createBookAsUri(book);
        Response response = RestAssured.delete(location);

        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
}
