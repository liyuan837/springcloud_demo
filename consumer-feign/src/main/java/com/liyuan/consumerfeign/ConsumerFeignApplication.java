package com.liyuan.consumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

import java.nio.charset.Charset;
import java.util.Base64;

@SpringBootApplication
//EnableDiscoveryClient：在注册中心注册消费者
@EnableDiscoveryClient
//EnableFeignClients：表示开启Spring Cloud Feign的支持功能
@EnableFeignClients
public class ConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignApplication.class, args);
	}
}
