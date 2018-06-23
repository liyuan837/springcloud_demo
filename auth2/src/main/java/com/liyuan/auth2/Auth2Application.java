package com.liyuan.auth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 认证服务器，进行认证和授权
 * （1）AuthorizationEndpoint:进行授权的服务，Default URL: /oauth/authorize
 * （2）TokenEndpoint：获取token的服务，Default URL: /oauth/token
 *
 * /oauth/authorize：验证
 * /oauth/token：获取token
 * /oauth/confirm_access：用户授权
 * /oauth/error：认证失败
 * /oauth/check_token：资源服务器用来校验token
 * /oauth/token_key：如果jwt模式则可以用此来从认证服务器获取公钥
 */
@SpringBootApplication
@EnableAuthorizationServer
public class Auth2Application {

	public static void main(String[] args) {
		SpringApplication.run(Auth2Application.class, args);
	}
}
