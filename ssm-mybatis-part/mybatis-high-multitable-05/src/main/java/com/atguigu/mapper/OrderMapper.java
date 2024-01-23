package com.atguigu.mapper;

import com.atguigu.pojo.Order;

public interface OrderMapper {

    // 根据id查询订单信息和关联的用户信息
    Order selectOrderWithCustomer(Integer orderId);
}
