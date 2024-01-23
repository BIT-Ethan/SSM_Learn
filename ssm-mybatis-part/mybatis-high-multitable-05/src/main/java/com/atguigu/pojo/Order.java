package com.atguigu.pojo;

import lombok.Data;

@Data
public class Order {

    private Integer orderId;

    private String orderName;

    private Integer customerId;
    // 一对一
    private Customer customer;
}
