package com.dx.base.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dx.base.shiro.bean.RoleMenu;
import com.dx.base.shiro.mapper.RoleMenuMapper;
import com.dx.base.shiro.service.RoleMenuService;
import org.springframework.stereotype.Service;


/**
 * Description: com.dx.base.shiro.service.impl
 *
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/8
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
}
