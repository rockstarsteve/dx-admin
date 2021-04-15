package com.dx.spring.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
public class AopTest {

    @Test
    public void AopTest() {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.dx.spring.aop");
        MyBean myBean = (MyBean) ctx.getBean("myBean");

        System.out.println(myBean);
        myBean.say();
    }


}
