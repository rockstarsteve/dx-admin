package com.dx.common.security;

import com.dx.sys.entity.SysUser;
import com.dx.sys.service.ISysUserService;
import com.dx.sys.service.impl.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Description: com.dx.common.auth
 * suecrity的登录用户信息
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/10
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private SysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<SysUser> sysUserList = sysUserService.loadUsersByUsername(username);

        if (sysUserList == null || sysUserList.size() == 0) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //用户所有的权限
        Set<String> menuPermission = permissionService.getMenuPermission(sysUserList.get(0));

        return new LoginUserDetails(sysUserList.get(0), menuPermission);

    }
}
