package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
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
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("root");
        user.setPassword("123456");
        int rows = mapper.insert(user);
        System.out.println("rows = " + rows);
        // 5.事务提交，关闭资源
        // 不提交事务数据库不会刷新，因为openSession()自动开启事务了
        // 只针对DML
        session.commit();
        session.close();
    }
}
