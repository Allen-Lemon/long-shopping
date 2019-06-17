package com.springcloud.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springcloud.entity.Users;


public interface UserRepository extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users> {

	/**
	 * 判断用户是否登陆成功
	 * @param userId		用户编号
	 * @param userPassword	用户密码
	 * @param authorityId	用户权限
	 * @return	 成功返回用户信息，失败返回null
	 * Users:是实体类中的表名
	 */
	@Query("select new com.springcloud.entity.Users(u.userId,u.userName,u.userIdentity,u.userPassword,u.userSex,u.userPhone,u.userAddress,u.userBirthday,u.userEmail,u.userImage,u.authorityId,u.userStatus)"
			+ "from Users u where u.userId=:userId and u.userPassword=:userPassword and u.authorityId=:authorityId and u.userStatus=0")
	public abstract Users login(@Param("userId") Integer userId,
			@Param("userPassword") String userPassword,
			@Param("authorityId") Integer authorityId);
	
	/**
	 * 修改用户的状态
	 * @param userStatus ，要修改用户状态的值
	 * @param userId 	   需要修改的用户id
	 * @return			 成功返回0，失败返回1
	 */
	@Modifying
	@Query("update Users set userStatus=:userStatus where userId=:userId")
	public abstract Integer updateStatus(@Param("userStatus") Integer userStatus,@Param("userId") Integer userId );
	
/**
 * 根据传入的用户信息修改用户的数据
 * @param users 传入要修改的数据
 * @return	成功返回大于0的整数，失败返回0
 */
	@Modifying
	@Query("update Users u set u.userIdentity=:#{#users.userIdentity},u.userSex=:#{#users.userSex},u.userPhone=:#{#users.userPhone},u.userBirthday=:#{#users.userBirthday},"
			+ "u.userEmail=:#{#users.userEmail},u.userAddress=:#{#users.userAddress} where u.userId=:#{#users.userId}")
	public abstract Integer updateUser(@Param("users")Users users);
}
