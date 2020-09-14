package com.dx.common.redis;

import com.dx.common.security.MyUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Description: com.dx.common.redis
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/13
 */
@Component
@Slf4j
public class RedisCache {


    private Map map = new HashMap();

    static {
        log.info("初始化redis。。。");
    }


    public MyUserDetails getCacheObject(String userKey) {
        MyUserDetails userDetails = (MyUserDetails) map.get(userKey);
        return userDetails;
    }

    public void setCacheObject(String userKey, MyUserDetails userDetails, int expireTime, TimeUnit minutes) {

        map.put(userKey, userDetails);
    }

    public void deleteObject(String userKey) {
        map.remove(userKey);
    }
}
