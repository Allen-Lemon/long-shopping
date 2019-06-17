package com.springcloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.repository.UserRepository;
import com.springcloud.service.UsersService;

/**
 * 
 * 项目名称：springcloud-cloud-02-user-provider 类名称：UsersServiceImpl 类描述： 创建人：admin
 * 创建时间：2019年5月13日 下午5:32:16
 * 
 * @version
 *
 */
@Service
public class UsersServiceImpl implements UsersService {
	/**
	 * 自动注入的jpa实现接口类
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * 实现用户登录
	 */
	@Override
//	@Cacheable(cacheNames = "loginUsers",key = "#userId")
	public Users login(Integer userId, String userPassword, Integer authorityId) {
		return this.userRepository.login(userId, userPassword, authorityId);
	}

	@Transactional
	@Override
	public Users insert(Users users) {

		return this.userRepository.save(users);
	}

	@Override
//	@Cacheable(cacheNames = "Page<Users>",key = "#pageNumber")
	public Page<Users> select(Users users, Integer pageNumber) {
		// 根据查询数据，创建动态条件
		@SuppressWarnings("serial")
		Specification<Users> pecification = new Specification<Users>() {

			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// 创建list
				List<Predicate> whereList = new ArrayList<>();
				// 创建users中的查询语句，动态创建查询条件
				if (users.getUserName() != null && !users.getUserName().trim().equals("")) {
					whereList.add(criteriaBuilder.like(root.get("userName"), "%" + users.getUserName() + "%"));
				}
				if (users.getUserStatus() != -1) {
					whereList.add(criteriaBuilder.equal(root.get("userStatus"), users.getUserStatus()));
				}
				return criteriaBuilder.and(whereList.toArray(new Predicate[whereList.size()]));
			}

		};
		// 创建jpa的分页信息
		PageRequest of = PageRequest.of(pageNumber, PageUtils.PAGE_ROW_COUNT);
		return this.userRepository.findAll(pecification, of);

	}

	/**
	 * 用户状态实现的转换
	 */
	@Transactional
	@Override
	public Integer updateStatus(Integer userStatus, Integer userId) {
		return this.userRepository.updateStatus(userStatus, userId);
	}

	/**
	 * 根据用户id查找用户信息
	 */
	@Override
	@Cacheable(cacheNames = "Users",key ="userId"+"#Users" )
	public Users selectUsersById(Integer userId) {
		return this.userRepository.findById(userId).get();
	}

	@Transactional
	@Override
	public Integer updateUsers(Users users) {
		return this.userRepository.updateUser(users);
	}

}
