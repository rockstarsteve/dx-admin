package com.dx.base.security.service.impl;

import com.dx.base.security.bean.LoginUser;
import com.dx.base.security.service.TokenCacheService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Description: com.dx.base.security.service.impl
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/24
 */
@Service
public class TokenCacheServiceImpl implements TokenCacheService {


    @Cacheable(value = "validCode",key = "#userKey")
    @Override
    public LoginUser getLoginUser(String userKey,LoginUser loginUser) {
        return loginUser;
    }


}
