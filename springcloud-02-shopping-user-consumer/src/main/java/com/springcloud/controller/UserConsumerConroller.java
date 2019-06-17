package com.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.Users;
import com.springcloud.fegin.FeginService;
import com.springcloud.vo.ResultValue;

@RestController
public class UserConsumerConroller {

	@Autowired
	private FeginService feginService;
	
	@RequestMapping("/select")
	public ResultValue select(Users users, @RequestParam("pageNumber") Integer pageNumber){
		
		ResultValue select = feginService.select(users,pageNumber);
		return select;
	}
	@RequestMapping("/login")
	public ResultValue login(@RequestParam(name = "userId") Integer userId,
			@RequestParam(name = "userPassword") String userPassword,
			@RequestParam(name = "authorityId") Integer authorityId) {
		
		ResultValue login = this.feginService.login(userId, userPassword, authorityId);
		return login;
		
	}
	
}
