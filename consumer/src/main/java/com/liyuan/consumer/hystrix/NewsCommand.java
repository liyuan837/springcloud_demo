package com.liyuan.consumer.hystrix;

import com.liyuan.consumer.domain.News;
import com.liyuan.consumer.domain.Result;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;

/**
 * @Author:LiYuan
 * @description:自定义熔断器
 * @Date:Create in 9:47 2018/3/2
 * @Modified By:
 */
public class NewsCommand extends HystrixCommand<Result<News>> {
    private RestTemplate restTemplate;

    private News news;

    /**
     * 构造方法的第一个参数是保存一些分组信息，后面参数不限，主要用来传递请求参数等信息
     */
    public NewsCommand(Setter setter, RestTemplate restTemplate, News news) {
        super(setter);
        this.restTemplate = restTemplate;
        this.news = news;
    }

    /**
     * 系统在运行时会根据getCacheKey方法的返回值来判断这个请求是否和之前执行过的请求一样
     * @return
     */
    @Override
    protected String getCacheKey() {
        System.out.println("key");
        return String.valueOf(news.getId());
    }

    /**
     * run方法实质性请求时调用
     * @return
     * @throws Exception
     */
    @Override
    protected Result<News> run() throws Exception {
        System.out.println("run");
        return restTemplate.getForEntity("http://NEWS/get/"+news.getId(),Result.class).getBody();
    }

    /**
     * getFallback方法将在服务调用失败是回调
     * @return
     */
    @Override
    protected Result<News> getFallback(){

        System.out.println("fallback");
        return new Result<News>();
    }
}
