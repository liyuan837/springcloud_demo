package com.liyuan.consumerfeign.service;

import com.liyuan.consumerfeign.domain.News;
import com.liyuan.consumerfeign.domain.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 15:58 2018/3/7
 * @Modified By:
 */
//通过@FeignClient注解来指定服务名（NEWS：不区分大小写）进而绑定服务
@FeignClient("news")
public interface HelloService {
    //通过SpringMVC中提供的注解来绑定服务提供者提供的接口
    @RequestMapping(value="/test" ,method = RequestMethod.GET)
    Result hello();

    @GetMapping("/get/{id}")
    //注意：下面的@PathVariable参数id一定要带，不然会报错
    //Get请求同样支持@RequestParams和PathVariable注解，注意请求路径
    Result consumer(@PathVariable("id") Integer id);

    @PostMapping("/post")
    //post请求支持@RequestBody注解
    Result post(@RequestBody News news);
}
