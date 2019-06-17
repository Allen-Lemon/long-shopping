package com.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: admin
 * @program: application
 * @description: （用户登录注册的controller）做用户数据交互的控制层
 * @author: Mr.Long
 * @create: 2019-04-12 19:24
 **/
@RestController
public class UserController {

	@RequestMapping("/")
	public String login() {
		return "这是一个登录请求";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "这是一个user请求";
	}
	@RequestMapping("/goods")
	public String goods() {
		return "这是一个goods请求";
	}
}
