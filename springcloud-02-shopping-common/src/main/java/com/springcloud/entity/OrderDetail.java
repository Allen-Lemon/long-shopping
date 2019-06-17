package com.springcloud.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail implements Serializable{
    /**
	 * 序列化编号
	 */
	private static final long serialVersionUID = -7234882544050463232L;

	/**
	 * 订单明细编号
	 */
	private Integer orderDetailId;

	/**
	 * 订单编号
	 */
    private Integer orderId;

    /**
          * 商品编号
     */
    private Integer goodsId;

    /**
            * 商品名称
     */
    private String goodsName;

    /**
             * 成交价
     */
    private Double transactionPrice;

    /**
            * 成交数量
     */
    private Integer transactionTotal;

    
}