package com.dx.mybatis;

import com.dx.mybatis.bean.User;
import com.dx.mybatis.mapper.UserMapper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
public class SqlSessionTest {

    private SqlSessionFactory factory;
    private SqlSession sqlSession;

    @Before
    public void init(){
        //获取构建器
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();

        //解析xml，构建会话工厂
        factory = factoryBuilder.build(Executor.class.getResourceAsStream("/mybatis-config.xml"));
        sqlSession = factory.openSession();
    }

    @Test
    public void test1(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUser("1");
        userList.stream().forEach(user -> {
            System.out.println(user.getUserName());
        });


        List<User> userList2 = mapper.getUser("2");
        userList2.stream().forEach(user -> {
            System.out.println(user.getUserName());
        });

    }



}
