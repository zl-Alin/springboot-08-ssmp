package com.alin.service;

import com.alin.pojo.Books;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;

public interface BookService {

    Boolean save(Books books);

    Boolean deleteById(Integer id);

    Boolean updateBook(Books books);

    Books getById(Integer id);

    List<Books> getAll();

    IPage<Books> getPage(Integer currentPage, Integer pageSize);

    List<Books> getBy(String condition);

}
