package com.test.spring.bean;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
public class SpringBeanAnnotationTest {

    @Test
    public void main() {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.test.spring.bean");
        MyBean myBean = (MyBean)ctx.getBean("myBean");
        System.out.println(myBean);

    }


}
