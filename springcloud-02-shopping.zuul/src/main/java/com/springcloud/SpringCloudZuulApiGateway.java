package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableAuthorizationServer    //添加oauth2的认证支持 
public class SpringCloudZuulApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulApiGateway.class, args);

	}

}
