package com.atguigu.mapper;

import com.atguigu.pojo.Customer;

import java.util.List;

public interface CustomerMapper {

    // 查询所有用户信息以及用户对应的订单信息
    List<Customer> queryList();
}
