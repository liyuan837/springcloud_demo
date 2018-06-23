package com.example.springclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableEurekaServer
//@EnableAuthorizationServer
public class SpringcloudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudDemoApplication.class, args);
	}
}
