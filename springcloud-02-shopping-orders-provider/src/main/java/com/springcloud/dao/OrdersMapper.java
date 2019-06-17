package com.springcloud.dao;

import com.springcloud.entity.Orders;
import java.util.List;

public interface OrdersMapper {
	int deleteByPrimaryKey(Integer orderId);

	int insert(Orders record);

	Orders selectByPrimaryKey(Integer orderId);

	List<Orders> selectAll();

	int updateByPrimaryKey(Orders record);

	/**
	 * 查询订单表orders中的满足条件的订单数据
	 * 
	 * @param orders 查询条件
	 * @return 返回满足条件的数据
	 */
	public abstract List<Orders> selectOrders(Orders orders);

	/**
	 * 修改订单表中订单的状态
	 * 
	 * @param orders ：传入订单表中对于要修改的订单order_id跟订单状态
	 * @return 成功返回大于0的数
	 */
	public abstract Integer updateOrdersStatus(Orders orders);
}