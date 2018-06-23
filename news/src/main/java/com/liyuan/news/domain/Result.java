package com.liyuan.news.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 9:00 2018/2/7
 * @Modified By:
 */
public class Result<T> {
    private ResultCode resultCode;

    private T data;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

//    public static void main(String[] args){
//        Result<List> result = new Result<List>();
//        result.setResultCode(ResultCode.SUCCESS);
//        List<News> list = new ArrayList<News>();
//        News news = new News();
//        news.setContent("sa");
//        list.add(news);
//        System.out.println(result.getResultCode());
//    }
}


