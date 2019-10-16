package com.dx.base.security.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: com.dx.base.security.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/15
 */
@Component
public class RedisCache {

    private Map<String, Object> map = new HashMap<>();


    /**
     * 获取对象
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getCacheObject(String key) {
        T obj = (T) map.get(key);
        return obj;

    }

    /**
     * 缓存基本的对象
     * @param key 缓存的键值
     * @param value 缓存的值
     * @param <T> 缓存的对象
     */
    public <T> void setCacheObject(String key, T value) {
        map.put(key,value);
    }


}
