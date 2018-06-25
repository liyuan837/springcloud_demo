package com.liyuan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
//@EnableAuthorizationServer
public class SpringCloudCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCenterApplication.class, args);
	}
}
