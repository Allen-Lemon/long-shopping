package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableEurekaClient   //设置服务提供者，在euraka注册中心的注册客户端
//@EnableCaching		 //开启缓存支持
//@EnableDiscoveryClient
public class UserProvider {

	public static void main(String[] args) {
		SpringApplication.run(UserProvider.class, args);
	}
}
