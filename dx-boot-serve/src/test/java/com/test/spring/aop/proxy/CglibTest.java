package com.test.spring.aop.proxy;

import com.test.spring.aop.MyBean;
import org.junit.Test;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/24
 */
public class CglibTest {


    @Test
    public void CglibTest(){
        CglibProxy cglibProxy = new CglibProxy();
        MyBean myBean = new MyBean();

        MyBean cglibIntenc = (MyBean)cglibProxy.createCglibIntenc(myBean);

//        System.out.println(cglibIntenc);
        cglibIntenc.say();

    }

}
