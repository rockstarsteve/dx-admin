package com.dx.sys.service;

import com.dx.sys.entity.SysUser;

/**
 * Description: com.dx.sys.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/13
 */
public interface LoginService {
    /**
     * 用户登录
     * @param sysUser
     * @return
     */
    String login(SysUser sysUser);
}
