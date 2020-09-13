package com.dx.common.redis;

import com.dx.common.security.MyUserDetails;
import org.springframework.stereotype.Component;

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
public class RedisCache {

    public MyUserDetails getCacheObject(String userKey) {
        return null;
    }

    public void setCacheObject(String userKey, MyUserDetails userDetails, int expireTime, TimeUnit minutes) {

    }
}
