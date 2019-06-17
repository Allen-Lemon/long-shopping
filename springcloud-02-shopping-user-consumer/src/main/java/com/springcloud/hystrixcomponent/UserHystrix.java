package com.springcloud.hystrixcomponent;

import org.springframework.stereotype.Component;

import com.springcloud.entity.Users;
import com.springcloud.fegin.FeginService;
import com.springcloud.vo.ResultValue;

@Component
public class UserHystrix implements FeginService{

	ResultValue rv=new ResultValue();
	@Override
	public ResultValue select(Users users, Integer pageNumber) {
		rv.setCode(1);
		rv.setMessage("查找数据失败");
		return rv;
	}

	@Override
	public ResultValue login(Integer userId, String userPassword, Integer authorityId) {
		rv.setCode(1);
		rv.setMessage("查找数据失败");
		return rv;
	}

}
