网关组件

1、主要依赖
        <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-zuul</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka</artifactId>
		</dependency>

2、配置路由规则，进行转发到相应的微服务
    zuul.routes.api-a.path=/api-feign-consumer/**
    zuul.routes.api-a.serviceId=spring-cloud-feign-consumer

    zuul.routes.api-b.path=/api-provider/**
    zuul.routes.api-b.serviceId=spring-cloud-provider

3、必要的情况下，可以在网关组件中做统一的权限校验
    public class AccessTokenFilter extends ZuulFilter