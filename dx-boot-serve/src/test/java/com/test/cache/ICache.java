package com.test.cache;

/**
 * describe:缓存数据类
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
public interface ICache {

    /**
     * 设置缓存
     * @return
     */
    boolean put(String key,Object val);

    /**
     * 获取缓存
     * @param key
     * @return
     */
    Object get(String key);


}
