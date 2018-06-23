服务提供者：需要在注册中心进行注册

1、如果注册中心未开启安全认证，则：
    配置文件中，注册配置如下
    eureka.client.serviceUrl.defaultZone=http://localhost:1111/eureka/,http://localhost:1112/eureka/
2、如果注册中心开启了安全认证，则：
    配置文件中，注册配置如下
    name=liyuan
    password=liyuan123456
    eureka.client.serviceUrl.defaultZone=http://${name}:${password}@localhost:1111/eureka/
