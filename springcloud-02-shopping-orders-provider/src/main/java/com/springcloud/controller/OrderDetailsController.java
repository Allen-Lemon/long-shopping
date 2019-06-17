package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.OrderDetail;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

/**
 * 实现订单的明细的模块的视图层 项目名称：springcloud-02-shopping-orders-provider
 * 类名称：OrderDetailsController 类描述： 创建人：admin 创建时间：2019年6月4日 下午2:43:13
 * 
 * @version
 *
 */

@RestController
@RequestMapping("orderDetails")
public class OrderDetailsController {
	@Autowired
	private OrdersService ordersService;

	@GetMapping("/selectByOrderId")
	public ResultValue selectByOrderId(@RequestParam("orderId") Integer orderId,
			@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			PageInfo<OrderDetail> selectOrderDetailsByOrderId = this.ordersService.selectOrderDetailsByOrderId(orderId,
					pageNumber);
			List<OrderDetail> list = selectOrderDetailsByOrderId.getList();
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				// 把查询的账单信息加到一个map中
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("orderDetails", list);
				// 把分页信息也传到前台
				PageUtils pageUtils = new PageUtils(selectOrderDetailsByOrderId.getPages() * 5);
				pageUtils.setPageNumber(pageNumber);
				map.put("pageUtil", pageUtils);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 没有查找到数据
		rv.setCode(1);
		rv.setMessage("没找到相应的数据");
		return rv;
	}

}
