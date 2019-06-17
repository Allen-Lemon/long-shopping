package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.OrderDetail;
import com.springcloud.entity.Orders;

/**
 * 订单模块的接口，实现账单的操作 项目名称：springcloud-02-shopping-orders-provider
 * 类名称：OrdersService 类描述： 创建人：admin 创建时间：2019年6月3日 上午10:33:48
 * 
 * @version
 *
 */
public interface OrdersService {

	/**
	 * 满足条件的订单信息
	 * 
	 * @param orders 传入查询的订单信息
	 * @return 返回满足条件订单的信息
	 * @param pageNumber 传入分页信息，第几页
	 * @return
	 */
	public abstract PageInfo<Orders> seleceOrder(Orders orders, Integer pageNumber);

	/**
	 * 根据订单的编号查询订单的详细信息
	 * 
	 * @param orderId 传入订单的编号
	 * @param pageNum 传入的分页
	 * @return 返回改订单的详细信息
	 */
	public abstract PageInfo<OrderDetail> selectOrderDetailsByOrderId(Integer orderId, Integer pageNumber);

	/**
	 * 根据订单的id来改变订单的状态
	 * 
	 * @param orders：需要修改的订单编号对应的订单状态
	 * @return 成功返回大于0的数
	 */
	public abstract Integer updateOrderStatusByOrederId(Orders orders);
}
