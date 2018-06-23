package com.liyuan.consumer.controller;
import com.liyuan.consumer.domain.Book;
import com.liyuan.consumer.domain.News;
import com.liyuan.consumer.domain.Result;
import com.liyuan.consumer.hystrix.NewsCommand;
import com.liyuan.consumer.service.HelloService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 14:00 2018/3/1
 * @Modified By:
 */
@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloService helloService;

    @GetMapping("/consumer")
    public Result hello() {
        //这边请求的是springcloud注册中心注册的服务名+具体方法
        return restTemplate.getForEntity("http://NEWS/get/1", Result.class).getBody();
    }

    @GetMapping("/test1/{id}")
    public String test1(@PathVariable Integer id){
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put("id",id);
        ResponseEntity<Result> responseEntity = restTemplate.getForEntity("http://NEWS/get/{id}", Result.class,map);
        Result body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return result.toString();
    }


    @GetMapping("/test2/{id}")
    public Result<News> test2(@PathVariable Integer id){
        HystrixRequestContext.initializeContext();
        helloService.test2(id);
        helloService.test2(id);
        return helloService.test2(id);
    }

    /**
     * 使用自定义熔断器
     * @param
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/test4")
    public Result test4(@RequestParam Integer id) throws ExecutionException{
        News news = new News();
        news.setId(id);
        NewsCommand newsCommand = new NewsCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),restTemplate,news);

        HystrixRequestContext.initializeContext();//初始化请求上下文
        return newsCommand.execute();
    }

    @PostMapping("/test3")
    public Result test3(@RequestBody News news) throws ExecutionException, InterruptedException {

        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("commandKey");
        HystrixRequestContext.initializeContext();

        NewsCommand newsCommand = new NewsCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")).andCommandKey(commandKey), restTemplate,news);

        NewsCommand newsCommand2 = new NewsCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")).andCommandKey(commandKey), restTemplate,news);
        NewsCommand newsCommand3 = new NewsCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")).andCommandKey(commandKey), restTemplate,news);

        HystrixRequestContext.initializeContext();

        //同步调用
        Result result = newsCommand.execute();
        Result result2 = newsCommand2.execute();
        Result result3 = newsCommand3.execute();

        System.out.println(result.getData().toString());
        System.out.println(result2.getData().toString());
        System.out.println(result3.getData().toString());


        return result;
    }


    //消费node服务：BOOK-SERVICE
    @GetMapping("/book")
    public Book book() {
        //这边请求的是springcloud注册中心注册的服务名+具体方法
        return restTemplate.getForEntity("http://BOOK-SERVICE/book", Book.class).getBody();
    }




}
