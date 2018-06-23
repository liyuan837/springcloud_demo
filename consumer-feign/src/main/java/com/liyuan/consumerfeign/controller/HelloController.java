package com.liyuan.consumerfeign.controller;

import com.liyuan.consumerfeign.domain.News;
import com.liyuan.consumerfeign.domain.Result;
import com.liyuan.consumerfeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 16:05 2018/3/7
 * @Modified By:
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    //不带参数get请求
    @RequestMapping(value="/test" ,method = RequestMethod.GET)
    public Result hello(){
        return helloService.hello();
    }

    //带参数的get请求
    @RequestMapping(value="/consumer/{id}",method = RequestMethod.GET)
    public Result consumer(@PathVariable Integer id){
        return helloService.consumer(id);
    }

    //带数据的POST请求
    @PostMapping("/post")
    public Result post(@RequestBody News news){
        return helloService.post(news);
    }
}
