package com.dx.cache;

/**
 * describe:
 * 存储缓存数据类
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
public interface ICacheStore {


    /**
     * 获取缓存
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 存储缓存的数据
     * @param key
     * @param val
     * @return
     */
    boolean save(String key,Object val);


}
