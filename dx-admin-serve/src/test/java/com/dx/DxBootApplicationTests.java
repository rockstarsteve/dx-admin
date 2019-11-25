package com.dx;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @author: yaoj
 * @Date: 2018/8/1 22:49
 * 版权所有：Copyright 2018 by 文理电信
 */
@SpringBootTest
public class DxBootApplicationTests {

    @Test
    public void test(){

        List<Object> objectList = new ArrayList<>();

        Map<String ,Object> map = new HashMap<>();

        Set<String> strings = map.keySet();

        Collection<Object> values = map.values();

        Iterator<Object> iterator = values.iterator();

        while (iterator.hasNext()){
            objectList.add(iterator.next());
        }

    }
}
