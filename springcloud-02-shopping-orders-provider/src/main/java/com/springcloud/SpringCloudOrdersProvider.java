package com.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching				//开启缓存支持
@MapperScan("com.springcloud.dao")
public class SpringCloudOrdersProvider {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrdersProvider.class, args);
	}
}
