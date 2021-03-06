package com.dx.service.service;

import com.dx.service.entity.SysMenu;
import com.dx.service.entity.vo.RouterVo;

import java.util.Collection;
import java.util.List;

/**
 * Description: com.dx.sys.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/21
 */
public interface ISysMenuService {
    /**
     *
     * @param userId
     * @return
     */
    Collection<? extends String> selectMenuPermsByUserId(String userId);

    /**
     * 获取树形结构
     * @param userId
     * @return
     */
    List<SysMenu> selectMenuTreeByUserId(String userId);

    /**
     * 构建树形菜单
     * @param menus
     * @return
     */
    List<RouterVo> buildMenus(List<SysMenu> menus);
}
