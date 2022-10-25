package com.alin.service.impl;

import com.alin.dao.BookDao;
import com.alin.pojo.Books;
import com.alin.service.BookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl2 implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Books books) {
        return bookDao.insert(books)>0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public Boolean updateBook(Books books) {
        return bookDao.updateById(books)>0;
    }

    @Override
    public Books getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Books> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Books> getPage(Integer currentPage, Integer pageSize) {
        IPage<Books> iPage=new Page<>(currentPage,pageSize);
        return bookDao.selectPage(iPage,null);
    }

    @Override
    public List<Books> getBy(String condition) {
        LambdaQueryWrapper<Books> lqw=new LambdaQueryWrapper<>();
        lqw.like(condition!=null,Books::getName,condition);
        return bookDao.selectList(lqw);
    }
}
