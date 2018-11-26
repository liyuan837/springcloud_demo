package com.liyuan.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 14:53 2018/6/28
 * @Modified By:
 */
@RestController
@RefreshScope//此注解，是在访问配置中心的/refresh后服务端加载新配置，自动把新配置注入
@RequestMapping("/config")
public class ConfigController {

    @Value("${from}")
    private  String from;

    @RequestMapping("/query")
    public String query(){
        return "from:"+from;
    }
}
