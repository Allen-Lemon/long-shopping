package com.springcloud.dao;

import com.springcloud.entity.OrderDetail;
import java.util.List;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer orderDetailId);

    int insert(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer orderDetailId);

    List<OrderDetail> selectAll();

    int updateByPrimaryKey(OrderDetail record);
    
    /**
     * 					根据订单编号查询订单的详细信息
     * @param orderId   传入订单的编号
     * @return 			查找成功返回订单的详细信息，否则返回null
     */
    public abstract List<OrderDetail> selectOrderDetailsByOrderId(Integer orderId);
}