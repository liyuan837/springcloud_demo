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
@RefreshScope
@RequestMapping("/config")
public class ConfigController {

    @Value("${from}")
    private  String from;

    @RequestMapping("/query")
    public String query(){
        return "from:"+from;
    }
}
