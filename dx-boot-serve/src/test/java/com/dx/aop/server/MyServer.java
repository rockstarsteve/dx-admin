package com.dx.aop.server;

import com.dx.aop.anno.AopAnno;
import org.springframework.stereotype.Service;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/04/14
 */
@Service
public class MyServer {


    @AopAnno("hello")
    public boolean add(String name){
        return true;
    }

}
