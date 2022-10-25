package com.alin.dao;

import com.alin.pojo.Books;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;

@SpringBootTest
public class BooksDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testGetAll(){
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testInsert(){
        Books book = new Books(7, "11", "22", "33");
        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Books book = new Books(7, "22", "33", "44");

        bookDao.updateById(book);
    }

    @Test
    void testDeleteById(){
        bookDao.deleteById(7);
    }

    @Test
    void testGetPage(){
        IPage page=new Page(1,5);
        bookDao.selectPage(page,null);
    }

    @Test
    void testGetBy(){
        String string="Spring";
        LambdaQueryWrapper<Books> lqw = new LambdaQueryWrapper<>();
        lqw.like(string!=null,Books::getName,string);
        bookDao.selectList(lqw);
    }

}
