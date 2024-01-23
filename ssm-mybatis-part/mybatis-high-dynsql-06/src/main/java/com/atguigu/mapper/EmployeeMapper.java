package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    // 根据员工的姓名和工资查询员工信息
    List<Employee> query(@Param("name") String name, @Param("salary")Double salary);

    // 根据员工id更新员工数据，要求传入的name和salary不为空的时候才更新
    int update(Employee employee);

    // 通过id批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

    // 通过id批量查询
    int deleteBatch(@Param("ids") List<Integer> ids);

    // 传入对象集合批量插入
    int insertBatch(@Param("employees") List<Employee> employees);

    // 批量修改
    int updateBatch(@Param("employees") List<Employee> employees);
}
