package com.dx.cache;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
public class Main {

    public static void main(String[] args) {
        ICache cache = new CacheImpl();
        cache.put("01","张三");


        Object obj = cache.get("01");
        System.out.println(obj);
    }

}
