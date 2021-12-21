package com.test.spring.aop.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/24
 */
public class CglibProxy implements MethodInterceptor {


    Object targetObject;// 目标对象

    public Object createCglibIntenc(Object targetObject) {
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();//通过类Enhancer创建代理对象
        enhancer.setSuperclass(this.targetObject.getClass());//传入创建代理对象的类
        enhancer.setCallback(this);//设置回调
        return enhancer.create();//创建代理对象

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        //原始未被代理的对象调用
//        Object resultObj = method.invoke(targetObject, objects);// 如果不为空交给目标对象进行处理.
        //代理后的对象调用
        Object resultObj = methodProxy.invokeSuper(o, objects);

        return resultObj;
    }

}
