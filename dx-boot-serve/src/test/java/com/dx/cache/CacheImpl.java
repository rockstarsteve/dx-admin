package com.dx.cache;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
public class CacheImpl implements ICache{

    private ICacheStore cacheStore = new MemoryStore();

    @Override
    public boolean put(String key, Object val) {
        boolean save = cacheStore.save(key, val);
        return save;
    }

    @Override
    public Object get(String key) {
        Object object = cacheStore.get(key);
        return object;
    }
}
