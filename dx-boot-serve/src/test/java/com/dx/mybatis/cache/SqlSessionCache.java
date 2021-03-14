package com.dx.mybatis.cache;

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
 * @date 2021/03/09
 */
public class SqlSessionCache {


    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private SqlSession sqlSession2;

    @Before
    public void init(){
        //获取构建器
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();

        //解析xml，构建会话工厂
        factory = factoryBuilder.build(Executor.class.getResourceAsStream("/mybatis-config.xml"));
        sqlSession = factory.openSession();
        sqlSession2 = factory.openSession();
    }

    @Test
    public void test1(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> user = mapper.getUser("1");
        sqlSession.commit();
        System.out.println(sqlSession);

        UserMapper mapper2 = sqlSession.getMapper(UserMapper.class);

        List<User> user2 = mapper2.getUser2("1");

        System.out.println(sqlSession);

    }


}
