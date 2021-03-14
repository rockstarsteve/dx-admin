package com.dx.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
public class SpringBeanAnnotationTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.dx.spring.bean");
        MyBean myBean = (MyBean)ctx.getBean("myBean2");


    }


}
