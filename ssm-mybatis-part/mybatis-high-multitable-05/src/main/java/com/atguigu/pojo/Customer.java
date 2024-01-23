package com.atguigu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Customer {

    private Integer customerId;

    private String customerName;
    // 一对多
    private List<Order> orders;
}
