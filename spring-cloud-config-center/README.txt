1、配置中心主要依赖：
        <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-config-server</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka</artifactId>
		</dependency>
2、配置文件中配置git相关信息

3、访问方式：
    http://localhost:5001/demospace/prod/master
    http://localhost:5001/{配置文件名前缀}/{配置文件版本}/git分支名