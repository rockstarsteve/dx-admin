package com.dx.base.security.service;

import com.dx.base.security.bean.SysUser;

/**
 * Description: com.dx.base.security.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/12
 */
public interface SysUserService {

    SysUser getByName(String username);
}
