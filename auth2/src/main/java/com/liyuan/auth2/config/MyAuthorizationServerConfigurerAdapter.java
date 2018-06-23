package com.liyuan.auth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 16:15 2018/3/8
 * @Modified By:
 */
@Configuration
public class MyAuthorizationServerConfigurerAdapter extends AuthorizationServerConfigurerAdapter
{
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // 使用in-memory存储
                .withClient("client") // client_id
                .secret("secret") // client_secret
                .authorizedGrantTypes("authorization_code") // 该client允许的授权类型
                .scopes("app"); // 允许的授权范围
        System.out.println("sa");
    }
}
