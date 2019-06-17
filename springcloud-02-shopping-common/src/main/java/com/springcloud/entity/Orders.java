package com.springcloud.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单的实体类 项目名称：springcloud-02-shopping-common 类名称：Orders 类描述： 创建人：admin
 * 创建时间：2019年5月31日 下午5:11:08
 * 
 * @version
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4102492535128508906L;

	/**
	 * 订单id
	 */
	private Integer orderId;

	/**
	 * 当前订单的用户信息
	 */
	private Users users;

	/**
	 * 收货人姓名,如果省略默认为用户表中的用户姓名
	 */
	private String consigneeName;

	/**
	 * 收货人电话,如果省略默认为用户表中的联系电话
	 */
	private String consigneePhone;

	/**
	 * 收货人地址,如果省略默认为用户表中的收货地址
	 */
	private String consigneeAddress;

	/**
	 * 下单时间,默认为当前时间
	 */
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date orderTime;

	/**
	 * 下单时间最小值
	 */
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date orderTimeMin;
	
	/**
	 * 下单时间最大值
	 */
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date orderTimeMax;
	/**
	 * 订单总额
	 */
	private Double orderTotal;

	/**
	 * 订单状态:0待付款,1待发货,2待收货,3已付款,4已退货
	 */
	private Integer orderStatus;

}