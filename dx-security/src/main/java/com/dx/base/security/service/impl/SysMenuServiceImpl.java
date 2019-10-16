package com.dx.base.security.service.impl;

import com.dx.base.security.bean.RouterVo;
import com.dx.base.security.bean.SysMenu;
import com.dx.base.security.service.SysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: com.dx.base.security.service.impl
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/16
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Override
    public List<SysMenu> selectMenuTreeByUserId(Long userId) {

        List<SysMenu> sysMenuList = new ArrayList<>();
        SysMenu sysMenu1 = new SysMenu();
        sysMenu1.setId("1");
        sysMenu1.setMenuName("系统管理");
        sysMenu1.setParentId("0");
        sysMenuList.add(sysMenu1);
        SysMenu sysMenu2 = new SysMenu();
        sysMenu2.setId("2");
        sysMenu2.setMenuName("用户管理菜单");
        sysMenu2.setParentId("0");
        sysMenuList.add(sysMenu2);
        SysMenu sysMenu3 = new SysMenu();
        sysMenu3.setId("3");
        sysMenu3.setMenuName("用户管理菜单");
        sysMenu3.setParentId("1");
        sysMenuList.add(sysMenu3);

        return sysMenuList;
    }

    @Override
    public List<RouterVo> buildMenus(List<SysMenu> menus) {
        List<RouterVo> routers = new LinkedList<RouterVo>();
        for (SysMenu menu : menus) {
            RouterVo router = new RouterVo();
            router.setName(menu.getMenuName());
            router.setPath(getRouterPath(menu));
            router.setComponent(StringUtils.isEmpty(menu.getComponent()) ? "Layout" : menu.getComponent());
//            router.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon()));
            router.setName(menu.getMenuName());
            List<SysMenu> cMenus = menu.getChildren();
            if (!cMenus.isEmpty() && cMenus.size() > 0 && "M".equals(menu.getMenuType())) {
                router.setAlwaysShow(true);
                router.setRedirect("noRedirect");
                router.setChildren(buildMenus(cMenus));
            }
            routers.add(router);
        }
        return routers;
    }
    /**
     * 获取路由地址
     *
     * @param menu 菜单信息
     * @return 路由地址
     */
    public String getRouterPath(SysMenu menu)
    {
        String routerPath = menu.getPath();
        // 非外链并且是一级目录
        if ("0" == menu.getParentId() && "1".equals(menu.getIsFrame()))
        {
            routerPath = "/" + menu.getPath();
        }
        return routerPath;
    }



}
