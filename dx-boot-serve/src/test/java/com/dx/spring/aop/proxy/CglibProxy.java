package com.dx.spring.aop.proxy;

import com.dx.spring.aop.MyBean;
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
    public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
        MyBean bean = (MyBean) targetObject;// 因为在程序里targetObject为PersonServiceBean
        Object result = null;
        if (bean != null)// 判断user是否为空
            result = method.invoke(targetObject, args);// 如果不为空交给目标对象进行处理.
        // TODO Auto-generated method stub
        return result;
    }

//    @Override
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        return null;
//    }
}
