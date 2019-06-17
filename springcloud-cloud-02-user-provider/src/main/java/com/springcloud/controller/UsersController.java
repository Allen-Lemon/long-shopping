package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.service.UsersService;
import com.springcloud.vo.ResultValue;

/**
 * 控制层，接收视图层的数据，并调用模型层的相应方法，将数据返回到视图层 项目名称：springcloud-cloud-02-user-provider
 * 类名称：UsersController 类描述： 创建人：admin 创建时间：2019年5月13日 下午5:40:42
 * 
 * @version
 *
 */

@RestController
public class UsersController {
	@Autowired
	private UsersService usersService;

	ResultValue rv = new ResultValue();

	/**
	 * 用户登录的控制层
	 * 
	 * @param userId：用户的id
	 * @param userPassword：用户密码
	 * @param authorityId：用户权限
	 * @return
	 */
	@RequestMapping("/login")
	public ResultValue login(@RequestParam(name = "userId") Integer userId,
			@RequestParam(name = "userPassword") String userPassword,
			@RequestParam(name = "authorityId") Integer authorityId) {

		try {
			Users login = this.usersService.login(userId, userPassword, authorityId);
			if (login != null) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>();
				map.put("loginUser", login);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("登录信息不正确");
		return rv;
	}

	@RequestMapping("/register")
	public ResultValue register(Users users) {

		try {
			Users insert = usersService.insert(users);
			// 当用户录入成功时
			if (insert != null) {
				rv.setCode(0);
				rv.setMessage("用户录入成功！！");
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 用户录入失败的时候，改变提示码
		rv.setCode(1);
		rv.setMessage("用户录入失败");
		return rv;
	}

	@RequestMapping(value = "/select")
	public ResultValue select(Users users, @RequestParam("pageNumber") Integer pageNumber) {
		try {

			Page<Users> page = this.usersService.select(users, pageNumber);
			List<Users> list = page.getContent();
			if (list != null && list.size() > 0) {
				System.err.println("成功------------------------------------------------------------------------");
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>(); // 把分页的数据加入到map中
				map.put("userList", list);
				PageUtils pageUtils = new PageUtils((int) page.getTotalElements());
				pageUtils.setPageNumber(pageNumber);

				// 将分页信息添加到map中
				map.put("pageUtils", pageUtils);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 没有查询到
		rv.setCode(1);
		return rv;

	}

	@RequestMapping("/updateStatus")
	public ResultValue updateStatus(@RequestParam("userStatus") Integer userStatus,
			@RequestParam("userId") Integer userId) {
		ResultValue rv = new ResultValue();
		Integer updateStatus = this.usersService.updateStatus(userStatus, userId);
		// 这里返回为1表示用户修改成功
		try {

			if (updateStatus > 0) {
				rv.setCode(0);
				rv.setMessage("用户状态修改成功");
				return rv;
			}
		} catch (Exception e) {

		}
		// 修改失败
		rv.setCode(1);
		return rv;
	}

	@RequestMapping("/select/{userId}")
	public ResultValue selectUserById(@PathVariable("userId") Integer userId) {
		ResultValue rv = new ResultValue();

		try {
			Users selectUsers = this.usersService.selectUsersById(userId);
			if (selectUsers != null) {
				// 设置返回的状态码
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>();
				// 把查询的数据加入到map中
				map.put("users", selectUsers);
				// 把指定的map加入到实体类中，把数据发送到前端
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		// 如果查询失败
		rv.setCode(1);
		rv.setMessage("查找用户数据失败");
		return rv;
	}

	@RequestMapping("/updateUsers")
	public ResultValue updateUsers(Users users) {
		ResultValue rv = new ResultValue();
		try {
			Integer updateUsers = this.usersService.updateUsers(users);
			if (updateUsers > 0) {

				rv.setCode(0);
				rv.setMessage("用户修改成功！！！");
				return rv;
			}
		} catch (Exception e) {

		}

		// 添加失败
		rv.setCode(1);
		rv.setMessage("修改用户信息失败");
		return rv;
	}
}
