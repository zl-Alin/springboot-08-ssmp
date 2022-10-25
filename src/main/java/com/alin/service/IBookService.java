package com.alin.service;

import com.alin.pojo.Books;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IBookService extends IService<Books> {

    List<Books> getByCondition(String condition);

    IPage<Books> getPage(Integer currentPage,Integer pageSize);

    IPage<Books> getPage(Integer currentPage,Integer pageSize,Books books);


}
