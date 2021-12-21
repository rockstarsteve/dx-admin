package com.test.aop;

import com.test.aop.server.MyServer;
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

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.test.aop");
        MyServer myServer = (MyServer) ctx.getBean("myServer");
        boolean flag = myServer.add("tom");

        System.out.println(flag);

    }


}
