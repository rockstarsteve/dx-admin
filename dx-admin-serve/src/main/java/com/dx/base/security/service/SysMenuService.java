package com.dx.base.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dx.base.security.bean.RouterVo;
import com.dx.base.security.bean.SysMenu;

import java.util.List;

/**
 * Description: com.dx.base.security.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/16
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 根据用户查询用户菜单list
     * @param userId
     * @return
     */
    List<SysMenu> selectMenuTreeByUserId(String userId);

    /**
     * 构建前端路由所需要的菜单
     *
     * @param menus 菜单列表
     * @return 路由列表
     */
    public List<RouterVo> buildMenus(List<SysMenu> menus);
}
