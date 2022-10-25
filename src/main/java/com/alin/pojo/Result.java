package com.alin.pojo;

import com.alibaba.druid.sql.PagerUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Boolean flag;
    private Object data;
    private String msg;

    public Result(Boolean flag){
        this.flag=flag;
    }

    public Result(Boolean flag , String msg){
        this.flag=flag;
        this.msg=msg;
    }

    public Result(boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }



    public Result(String msg){
        this.flag=false;
        this.msg=msg;
    }

}
