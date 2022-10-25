package com.alin.service.impl;

import com.alin.dao.BookDao;
import com.alin.pojo.Books;
import com.alin.service.IBookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Books> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Books> getByCondition(String condition) {
        System.out.println("test1");
        System.out.println("test2");
        System.out.println("test3");
        System.out.println("test4");
        System.out.println("test5");
        System.out.println("push test");
        System.out.println("push test2");

        LambdaQueryWrapper<Books> lqw=new LambdaQueryWrapper();
        lqw.like(condition!=null,Books::getName,condition);
        List<Books> books = bookDao.selectList(lqw);
        return books;
    }

    @Override
    public IPage<Books> getPage(Integer currentPage, Integer pageSize) {
        IPage<Books> page=new Page<>(currentPage,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Books> getPage(Integer currentPage, Integer pageSize, Books books) {
        IPage<Books> page=new Page<>(currentPage,pageSize);
        LambdaQueryWrapper<Books> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(books.getType()),Books::getType,books.getType());
        lqw.like(Strings.isNotEmpty(books.getName()),Books::getName,books.getName());
        lqw.like(Strings.isNotEmpty(books.getDescription()),Books::getDescription,books.getDescription());

        bookDao.selectPage(page,lqw);
        return page;
    }
}
