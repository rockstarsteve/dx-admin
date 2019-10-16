package com.dx.base.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dx.base.shiro.bean.Role;
import com.dx.base.shiro.mapper.RoleMapper;
import com.dx.base.shiro.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * Description: com.dx.base.shiro.service.impl
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/30
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
