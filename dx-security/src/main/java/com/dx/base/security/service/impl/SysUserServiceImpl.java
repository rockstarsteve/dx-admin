package com.dx.base.security.service.impl;

import com.dx.base.security.bean.SysUser;
import com.dx.base.security.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * Description: com.dx.base.security.service.impl
 *
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/12
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    //TODO 暂时写死，不从数据库中获取
    @Override
    public SysUser getByName(String username) {
        if (username.equals("tom")) {
            SysUser sysUser = new SysUser("tom", "123456");
            return sysUser;
        } else {
            return null;
        }


    }
}
