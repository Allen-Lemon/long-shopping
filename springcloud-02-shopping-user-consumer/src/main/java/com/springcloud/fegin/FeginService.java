package com.springcloud.fegin;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springcloud.entity.Users;
import com.springcloud.hystrixcomponent.UserHystrix;
import com.springcloud.vo.ResultValue;

@FeignClient(name = "USER-PROVIDER",fallback = UserHystrix.class)
@Component
public interface FeginService {

	@RequestMapping("/select")
	public abstract ResultValue select(@RequestBody Users users, @RequestParam("pageNumber") Integer pageNumber);
	
	@RequestMapping("/login")
	public ResultValue login(@RequestParam(name = "userId") Integer userId,
			@RequestParam(name = "userPassword") String userPassword,
			@RequestParam(name = "authorityId") Integer authorityId);
}
