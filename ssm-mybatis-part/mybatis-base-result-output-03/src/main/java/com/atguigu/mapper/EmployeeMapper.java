package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    // DML 返回类型为int
    int deleteById(Integer id);

    // DQL 返回类型需要指定
    // 根据员工的id查询员工的姓名
    String queryNameById(Integer id);

    // 根据员工的id查询员工的薪水
    Double querySalaryById(Integer id);

    // 根据员工id查询员工信息
    Employee queryById(Integer id);

    // 查询工资高于传入值的员工姓名们
    List<String> queryNamesBySalary(Double salary);

    // 查询全部员工信息
    List<Employee> queryAll();

    // 员工插入
    int insertEmp(Employee employee);
}
