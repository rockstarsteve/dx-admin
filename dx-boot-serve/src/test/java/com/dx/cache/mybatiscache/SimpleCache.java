package com.dx.cache.mybatiscache;

import com.dx.mybatis.bean.User;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/09
 */
public class SimpleCache {

    private Configuration configuration;
    private SqlSessionFactory factory;

    @Before
    public void init(){
        //获取构建器
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //解析xml
        factory = factoryBuilder.build(Executor.class.getResourceAsStream("/mybatis-config.xml"));
        configuration = factory.getConfiguration();
    }

    @Test
    public void test1(){
        Cache cache = configuration.getCache("com.dx.mybatis.mapper.UserMapper");
        User user = new User();
        user.setUserId("01");
        user.setUserName("tom");
        cache.putObject("001",user);
        User object = (User)cache.getObject("001");
        System.out.println(object);


    }
}
