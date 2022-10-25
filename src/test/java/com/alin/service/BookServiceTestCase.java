package com.alin.service;

import com.alin.pojo.Books;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;

    @Test
    void testSave(){
        Books books = new Books();
        books.setType("111");
        books.setName("222");
        books.setDescription("222");

        bookService.save(books);
    }

    @Test
    void testDelete(){
        bookService.deleteById(8);
    }

    @Test
    void testUpdate(){
        Books books = new Books();
        books.setId(8);
        books.setType("222");
        books.setName("333");
        books.setDescription("444");

        bookService.updateBook(books);
    }

    @Test
    void testGetById(){
        bookService.getById(2);
    }

    @Test
    void testGetAll(){
        bookService.getAll();
    }

    @Test
    void testGetPage(){
        bookService.getPage(2,5);
    }

    @Test
    void testGetBy(){
        bookService.getBy("Spring");
    }

}
