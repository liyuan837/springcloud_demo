package com.liyuan.gateapi;

import com.liyuan.gateapi.filter.PermisFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableZuulProxy注解表示开启Zuul的API网关服务功能
@EnableZuulProxy
public class GateApiApplication {

	@Bean
	PermisFilter permisFilter() {
		return new PermisFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(GateApiApplication.class, args);
	}
}
