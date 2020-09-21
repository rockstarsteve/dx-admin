package com.dx.sys.service.impl;

import com.dx.sys.entity.SysRole;
import com.dx.sys.mapper.SysRoleMapper;
import com.dx.sys.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Description: com.dx.sys.service.impl
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/21
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Collection<? extends String> selectRolePermissionByUserId(String userId) {
        List<SysRole> sysRoleList = sysRoleMapper.selectRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole sysRole : sysRoleList) {
            if (sysRole != null) {
                permsSet.addAll(Arrays.asList(sysRole.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }
}
