package com.dx.base.security.service.impl;

import com.dx.base.security.service.CaptchaCacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Description: com.dx.base.security.service.impl
 * 验证码缓存对象
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/24
 */
@Service
public class CaptchaCacheServiceImpl implements CaptchaCacheService {


    @Cacheable(value = "validCode",key = "#verifyKey")
    @Override
    public String getVerifyCode(String verifyKey, String verifyCode) {
        return verifyCode;
    }


    @Override
    @CacheEvict(value = "validCode", key = "#verifyKey")
//    @CacheEvict(value = USER_CACHE_NAME, key = "'user_' + #id")
    public void delete(String verifyKey) {

    }

}
