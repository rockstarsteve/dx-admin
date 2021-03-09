package com.dx.proxy;

import sun.misc.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * describe:
 * jdk代理测试
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
public class JdkProxyMain {

    public static void main(String[] args) throws Exception {

        UserService userService = (UserService) Proxy.newProxyInstance(
                JdkProxyMain.class.getClassLoader(),
                new Class[]{UserService.class},
                new UserInvocationHandlerImpl());

        byte[] $ProxiesByte = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{userService.getClass()});

        Files.write(Paths.get(System.getProperty("user.dir") + "/target/proxyInstance.class"),$ProxiesByte);

        userService.hello();
    }
}

class UserInvocationHandlerImpl implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入了invoke。。。。");

        if (method.getName().equals("hello") && args == null) {
            System.out.println("你好");
            return "你好";
        } else if (method.getName().equals("hello") && args.length == 1) {
            System.out.println("你好：" + args[0] + "先生");
            return null;
        } else {
            return null;
        }
    }
}

interface UserService {
    void hello();

    String hello(String name);
}

