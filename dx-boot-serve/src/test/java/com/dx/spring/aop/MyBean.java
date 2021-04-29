package com.dx.spring.aop;

import org.springframework.stereotype.Component;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/05
 */
@Component
public class MyBean {

    private String city = "长沙";

    public void say(){
        System.out.println(this);
        System.out.println("hello world");
    }

}
