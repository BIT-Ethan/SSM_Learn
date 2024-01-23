package com.atguigu.mapper;

import com.atguigu.pojo.Employee;

public interface EmployeeMapper {

    // 根据id查询员工信息
    Employee queryById(Integer id);

    // 根据id 删除
    int deleteById(Integer id);

}
