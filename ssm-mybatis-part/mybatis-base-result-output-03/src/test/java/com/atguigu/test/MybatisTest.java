package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    @Test
    public void test1() throws IOException {
        // 1.读取外部配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2.创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 3.获取业务对象
        SqlSession session = sqlSessionFactory.openSession();
        // 4.获取代理对象
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpName("lrk");
        employee.setEmpSalary(3208.0);
        System.out.println(employee.getEmpId());
        int rows = mapper.insertEmp(employee);
        System.out.println("----------");
        System.out.println(employee.getEmpId());
        System.out.println("rows = " + rows);
        // 5.事务提交，关闭资源
        // 不提交事务数据库不会刷新，因为openSession()自动开启事务了
        // 只针对DML
        session.commit();
        session.close();
    }
}
