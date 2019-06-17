package com.springcloud.service;


import org.springframework.data.domain.Page;

import com.springcloud.entity.Users;

public interface UsersService {

	/**
	 * 判断用户是否登陆成功
	 * @param userId		用户编号
	 * @param userPassword	用户密码
	 * @param authorityId	用户权限
	 * @return	 成功返回用户信息，失败返回null
	 * Users:是实体类中的表名
	 */
	public abstract Users login(Integer userId,String userPassword,Integer authorityId);
    /**
     * 实现用户注册
     * @param users：需要插入的用户详细信息
     * @return
     */
	public abstract Users insert(Users users);
	
	/**
	 * 查询用户数据 ，并分页显示
	 * @param users
	 * @param pageNumber
	 * @return
	 */
	public abstract Page<Users> select(Users users,Integer pageNumber);
	
	/**
	 * 业务层：修改用户的状态
	 * @param userStatus
	 * @param userId
	 * @return
	 */
	public abstract Integer updateStatus(Integer userStatus,Integer userId);

	/**
	 * 根据用户id查找用户数据
	 * @param userId 用户id
	 * @return		 用户数据
	 */
	public abstract Users selectUsersById(Integer userId);
	
	/**
	 * 修改指定用户的信息
	 * @param users 传入修改的用户信息
	 * @return 		成功返回大于0的整数，失败返回0
	 */
	public abstract Integer updateUsers(Users users);
}
