package com.test.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/24
 */
@Component
@Aspect
public class AspectCustomer {


    @Pointcut("execution(public * com.test.spring.aop.*.*(..))")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void befor(){
        System.out.println("在切入方法之前执行。。。。");
    }

}
