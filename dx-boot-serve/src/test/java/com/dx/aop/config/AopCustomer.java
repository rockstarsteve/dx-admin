package com.dx.aop.config;

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
public class AopCustomer {

    @Pointcut("@annotation(com.dx.aop.anno.AopAnno)")
//    @Pointcut("execution(public * com.dx.aop.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(){
        System.out.println("在切入方法之前执行。。。。");
    }

}
