package com.alin.controller;

import com.alin.pojo.Books;
import com.alin.pojo.Result;
import com.alin.service.BookService;
import com.alin.service.IBookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public Result getAll(){
        if(bookService.list()!=null)
            return new Result(true,bookService.list(),"查询成功");
        else
            return new Result("服务器异常，请联系管理员");
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        if(bookService.getById(id)!=null)
            return new Result(true,bookService.getById(id),"查询成功") ;
        else
            return new Result("服务器异常，请联系管理员");
    }

    /**
     * 新增
     * @param books
     */
    @PostMapping
    public Result save(@RequestBody Books books) throws IOException {
        boolean flag = bookService.save(books);
        return new Result(flag,flag?"新增成功":"新增失败");
//        return new Result(false);

    };

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Integer id){
        boolean flag = bookService.removeById(id);
        return new Result(flag,flag?"删除成功":"删除失败");
    }

    /**
     *更新
     * @return
     */
    @PutMapping
    public Result updateById(@RequestBody Books books){
        boolean flag = bookService.updateById(books);
        return new Result(flag,flag?"更新成功":"更新失败");
    }

    /**
     *分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    /*@GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        try {
            IPage<Books> page = bookService.getPage(currentPage, pageSize);
            if(currentPage>page.getPages()){
                //当当前页码值大于最大页码值，用最大页码值作为当前页码值
                page=bookService.getPage((int)page.getPages(), pageSize);
            }
            return new Result(true,page) ;
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"服务器异常");
        }

    }*/

    /**
     *分页条件查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,Books books){

        try {
            IPage<Books> page = bookService.getPage(currentPage, pageSize,books);
            if(currentPage>page.getPages()){
                //当当前页码值大于最大页码值，用最大页码值作为当前页码值
                page=bookService.getPage((int)page.getPages(), pageSize,books);
            }
            return new Result(true,page) ;
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"服务器异常");
        }

    }

    /**
     * 根据条件查询
     * @param condition
     * @return
     */
   /* @GetMapping("{condition}")
    public List<Books> getByCondition(@PathVariable String condition){
        return bookService.getByCondition(condition);
    }*/





}
