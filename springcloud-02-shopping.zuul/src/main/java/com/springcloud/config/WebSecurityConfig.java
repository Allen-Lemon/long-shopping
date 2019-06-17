package com.springcloud.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * springSecurity的核心配置类
* 项目名称：springcloud-02-shopping.zuul   
* 类名称：WebSecurityConfig   
* 类描述：   
* 创建人：admin   
* 创建时间：2019年6月10日 下午2:59:50     
* @version    
*
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 * 安全设置
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//permitAll是所有角色都可以访问,每个条件完在写下一个条件的时候都要加上一个and,而且每个请求都要加上角色信息
		.antMatchers("/").permitAll()
		.antMatchers("/user").hasRole("user")
		.antMatchers("/goods").hasRole("admin")
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll();
	}
	/**
	 * 用户权限认证规则
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	auth.inMemoryAuthentication()
	.withUser("z").password("1").roles("user","admin")
	.and()
	.withUser("l").password("11").roles("admin");
	
	
	}

}
