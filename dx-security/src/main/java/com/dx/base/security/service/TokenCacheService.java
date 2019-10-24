package com.dx.base.security.service;

import com.dx.base.security.bean.LoginUser;

/**
 * Description: com.dx.base.security.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/24
 */
public interface TokenCacheService {

    LoginUser getLoginUser(String userKey,LoginUser loginUser);

}
