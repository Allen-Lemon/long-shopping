package com.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.dao.OrderDetailMapper;
import com.springcloud.dao.OrdersMapper;
import com.springcloud.entity.OrderDetail;
import com.springcloud.entity.Orders;
import com.springcloud.entity.Users;
import com.springcloud.service.OrdersService;

/**
 * 实现订单查询的接口 项目名称：springcloud-02-shopping-orders-provider 类名称：OrdersServiceImpl
 * 类描述： 创建人：admin 创建时间：2019年6月3日 上午10:38:13
 * 
 * @version
 *
 */
@Service
public class OrdersServiceImpl implements OrdersService {

	/**
	 * 账单dao层的mapper，自动注入
	 */
	@Autowired
	private OrdersMapper ordersMapper;

	@Autowired
	private OrderDetailMapper orderDetailMapper;

	/**
	 * 设置满足条件的账单信息
	 */
	@Override
	@Cacheable(cacheNames = "PageInfo<Orders>",key = "#pageNumber")
	public PageInfo<Orders> seleceOrder(Orders orders, Integer pageNumber) {
		if (orders.getUsers() != null) {
			orders.getUsers().setUserName("%" + orders.getUsers().getUserName() + "%");
		}
		/**
		 * 
		 */
		PageHelper.startPage(pageNumber + 1, PageUtils.PAGE_ROW_COUNT);
		List<Orders> selectOrders = this.ordersMapper.selectOrders(orders);
		return new PageInfo<>(selectOrders);
	}

	/**
	 * 实现订单详细信息的接口
	 */
	@Override
	public PageInfo<OrderDetail> selectOrderDetailsByOrderId(Integer orderId, Integer pageNumber) {
		PageHelper.startPage(pageNumber+1, 5);
		List<OrderDetail> selectOrderDetailsByOrderId = this.orderDetailMapper.selectOrderDetailsByOrderId(orderId);
		return new PageInfo<OrderDetail>(selectOrderDetailsByOrderId);
	}

	/**
	 * 根据订单编号修改订单的状态
	 */
	@Override
	public Integer updateOrderStatusByOrederId(Orders orders) {
		return this.ordersMapper.updateOrdersStatus(orders);
	}

}
