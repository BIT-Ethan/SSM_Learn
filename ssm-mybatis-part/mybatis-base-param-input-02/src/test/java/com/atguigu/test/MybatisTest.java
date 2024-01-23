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
        Employee employee = mapper.queryById(1);
        System.out.println("employee = " + employee);
        // 5.关闭资源or事务提交
        session.close();
    }
}
