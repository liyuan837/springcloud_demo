package com.liyuan.consumer.service;

import com.liyuan.consumer.domain.News;
import com.liyuan.consumer.domain.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 9:18 2018/3/2
 * @Modified By:
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    @CacheResult
    @HystrixCommand(fallbackMethod = "error")
    public Result<News> test2(Integer id){
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put("id",id);
        Result<News> body = restTemplate.getForObject("http://NEWS/get/{id}", Result.class,map);

        return body;
    }

    public Result<News> error(Integer id) {
        return new Result<News>();
    }
}
