package com.dx.test.service.impl;

import com.dx.test.bean.TestBean;
import com.dx.test.service.TestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Description: com.dx.service.impl
 *
 *
 * 
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceImplTest {

    @Autowired
    private TestService testService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test(){

        List<TestBean> list = testService.list();

        list.forEach(testBean -> System.out.println(list));

    }


    @Test
    public void testSql(){

        List<TestBean> list = testService.testSql("tom");

        list.forEach(testBean -> System.out.println(list));

    }


    @Test
    public void insert(){

        boolean save = testService.save(new TestBean(null,"tom",1));

        System.out.println(save);

    }


}