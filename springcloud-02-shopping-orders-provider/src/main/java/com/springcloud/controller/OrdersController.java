package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

/**
 * 订单视图层的实现类 项目名称：springcloud-02-shopping-orders-provider 类名称：OrdersController
 * 类描述： 创建人：admin 创建时间：2019年6月3日 上午11:00:36
 * 
 * @version
 *
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	// 设置返回统一的类型
	ResultValue rv = new ResultValue();

	/**
	 * 根据传入信息查询满足条件的账单信息
	 * 
	 * @param orders     传入查询的账单信息
	 * @param pageNumber 传入分页信息
	 * @return
	 */
	@RequestMapping("/selectOrders")
	public ResultValue selectOrders(Orders orders, @RequestParam("pageNumber") Integer pageNumber) {
		try {
			PageInfo<Orders> seleceOrder = this.ordersService.seleceOrder(orders, pageNumber);

			List<Orders> list = seleceOrder.getList();
			// 查询账单成功
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("pageOrders", list);
				// 把分页数据传入到前端
				PageUtils pageUtils = new PageUtils(seleceOrder.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				map.put("pageUtil", pageUtils);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 查询失败的时候
		rv.setCode(1);
		rv.setMessage("查询数据失败");
		return rv;
	}

	/**
	 * 根据订单的编号修改订单的状态
	 * 
	 * @param orders 传入修改的订单
	 * @return 成功返回前端0，失败返回1
	 */
	@PostMapping("/updateOrderStatus")
	public ResultValue updateOrderStatus(Orders orders) {
		try {
			Integer updateorderStatus = this.ordersService.updateOrderStatusByOrederId(orders);
			// 修改成功
			if (updateorderStatus > 0) {
				rv.setCode(0);
				return rv;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		// 修改失败
		rv.setCode(1);
		rv.setMessage("修改状态失败");
		return rv;
	}
}
