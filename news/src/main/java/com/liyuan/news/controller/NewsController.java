package com.liyuan.news.controller;

import com.liyuan.news.domain.*;
import com.liyuan.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 8:59 2018/2/7
 * @Modified By:
 */
@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/test")
    public Result test() throws InterruptedException {
//        Thread.sleep(15000);

        News news = newsService.find(1);

        Result<News> result = new Result<>();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(news);

        return result;
    }

    @GetMapping("/get")
    public Result<PageResult<News>> get(PageGet pageGet){
        Page<News> pageQuery = newsService.findAll(pageGet);

        PageResult<News> pageResult = new PageResult<News>();
        pageResult.setContent(pageQuery.getContent());
        pageResult.setTotalPages(pageQuery.getTotalPages());

        Result<PageResult<News>> result = new Result<PageResult<News>>();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(pageResult);
        return result;
    }

    @PostMapping("/post")
    public Result post(@RequestBody News news){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            news.setPublishtime(sdf.parse(sdf.format(date)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        News resultNews = newsService.save(news);

        Result<News> result = new Result<News>();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(resultNews);

        return result;
    }

    @GetMapping("/get/{id}")
    public Result getNews(@PathVariable("id") Integer id){
        News news = newsService.find(id);

        Result<News> result = new Result<>();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(news);

        return result;
    }

}
