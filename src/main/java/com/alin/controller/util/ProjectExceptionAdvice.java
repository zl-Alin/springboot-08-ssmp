package com.alin.controller.util;

import com.alin.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler
    public Result handler(Exception e){
        //记录日志
        //通知运维
        //通知开发
        e.printStackTrace();
        return new Result("服务器异常，请联系管理员");
    }

}
