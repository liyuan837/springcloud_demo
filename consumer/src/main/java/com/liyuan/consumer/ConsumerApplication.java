package com.liyuan.consumer;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//EnableDiscoveryClient:声明此服务是服务消费者
@EnableDiscoveryClient
//EnableCircuitBreaker:开启断路器功能
@EnableCircuitBreaker
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	//@LoadBalanced：实现客户端负载均衡
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public HystrixCommandAspect hystrixCommandAspect() {
		return new HystrixCommandAspect();
	}
}
