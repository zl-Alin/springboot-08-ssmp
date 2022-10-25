package com.alin.service;

import com.alin.pojo.Books;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BooServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    void testSave(){
        Books books = new Books();
        books.setType("111");
        books.setName("222");
        books.setDescription("333");
        bookService.save(books);
    }

    @Test
    void testRemove(){
        bookService.removeById(9);
    }

    @Test
    void testUpdate(){
        Books books = new Books();
        books.setId(9);
        books.setType("222");
        books.setName("333");
        books.setDescription("444");
        bookService.updateById(books);
    }

    @Test
    void testGetById(){
        bookService.getById(9);
    }

    @Test
    void testGetAll(){
        bookService.list();
    }

    @Test
    void testGetPage(){
        IPage<Books> iPage=new Page<>(1,5);
        bookService.page(iPage);
    }

    @Test
    void testGetByCondition(){
        System.out.println(bookService.getByCondition("Spring"));
    }

}
