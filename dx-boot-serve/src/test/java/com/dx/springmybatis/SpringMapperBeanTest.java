package com.dx.springmybatis;

import com.dx.mybatis.bean.User;
import com.dx.mybatis.mapper.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
public class SpringMapperBeanTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.dx.springmybatis");
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        for (int i = 0; i < beanDefinitionNames.length; i++) {
//            System.out.println(beanDefinitionNames[i]);
//        }
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");

        //开启事务
//        DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) ctx.getBean("txmanager");
//        TransactionStatus transaction = transactionManager.getTransaction(new DefaultTransactionDefinition());


        List<User> user = userMapper.getUser("1");
        List<User> user2 = userMapper.getUser("1");


    }


}
