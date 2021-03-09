package com.dx.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
public class MemoryStore implements ICacheStore {

    private final Map<String, Object> cacheMap = new HashMap<>();

    @Override
    public Object get(String key) {
        Object obj = cacheMap.get(key);
        return obj;
    }

    @Override
    public boolean save(String key, Object val) {
        cacheMap.put(key,val);
        return true;
    }
}
