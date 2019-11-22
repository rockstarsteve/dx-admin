package com.dx.base.security.service;

/**
 * Description: com.dx.base.security.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/24
 */
public interface SysLoginService {


    /**
     * 登录验证
     *
     * @param username
     * @param password
     * @param code
     * @param uuid
     * @return
     */
    String login(String username, String password, String code, String uuid);

}
