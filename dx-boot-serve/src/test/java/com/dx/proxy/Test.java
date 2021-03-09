package com.dx.proxy;

import sun.misc.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
public class Test {

    public static void main(String[] args) throws Exception {

        DidiNima didiNima = (DidiNima) Proxy.newProxyInstance(Test.class.getClassLoader(),
                new Class[]{DidiNima.class},
                new InterfaceInvocationHandler(new DidiNimaImpl()));

        byte[] $test = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{didiNima.getClass()});

        Files.write(Paths.get(System.getProperty("user.dir") + "/target/$test.class"),$test);


        didiNima.didi();
    }
}

interface DidiNima{

    String didi();
}

class DidiNimaImpl implements DidiNima{

    @Override
    public String didi() {
        return "臭弟弟";
    }
}

class InterfaceInvocationHandler<T> implements InvocationHandler{

    private T target;

    public InterfaceInvocationHandler(T target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        System.out.println("reult:" + result);
        return result;
    }
}