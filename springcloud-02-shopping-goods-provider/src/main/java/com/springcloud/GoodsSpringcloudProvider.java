package com.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableEurekaClient
@MapperScan("com.springcloud.dao")
//@EnableCaching
public class GoodsSpringcloudProvider {
	
public static void main(String[] args) {
	SpringApplication.run(GoodsSpringcloudProvider.class, args);
}
}
