package com.liyuan.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//声明为保护资源
//@EnableResourceServer
public class NewsApplication {
	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}
}
