package com.dx.base.shiro.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dx.base.shiro.bean.Menu;

import java.util.List;
import java.util.Set;


/**
 * Description: com.dx.base.shiro.service
 * 菜单管理
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/8
 */
public interface MenuService extends IService<Menu> {

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 * @param menuIdList  用户菜单ID
	 */
	List<Menu> queryListParentId(String parentId, List<String> menuIdList);

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<Menu> queryListParentId(String parentId);
	
	/**
	 * 获取用户菜单列表
	 * @param username
	 * @return
	 */
	List<Menu> getUserMenuList(String username);

	/**
	 * 获取用户的权限
	 * @param username
	 * @return
	 */
	Set<String> getUserPermissions(String username);
}
