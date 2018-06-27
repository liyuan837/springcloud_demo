package com.liyuan.demo;

import com.liyuan.demo.filter.AccessTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
//表示开启Zuul的API网关服务功能
@EnableZuulProxy
public class DemoApplication {

	@Bean
	AccessTokenFilter accessTokenFilter() {
		return new AccessTokenFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}