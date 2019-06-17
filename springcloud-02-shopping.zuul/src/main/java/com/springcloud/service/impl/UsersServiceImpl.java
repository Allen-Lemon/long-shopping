package com.springcloud.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springcloud.entity.Users;

/**
 * 实现用户的认证 
* 项目名称：springcloud-02-shopping.zuul   
* 类名称：UsersServiceImpl   
* 类描述：   
* 创建人：admin   
* 创建时间：2019年6月9日 下午1:34:45     
* @version    
*
 */
@Service
public class UsersServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users =new Users();
		return null;
	}
	

}
