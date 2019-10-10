package com.dx.base.shiro.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dx.base.shiro.bean.Menu;
import com.dx.base.shiro.mapper.MenuMapper;
import com.dx.base.shiro.mapper.UserMapper;
import com.dx.base.shiro.service.MenuService;
import com.dx.base.shiro.service.UserService;
import com.dx.base.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;


/**
 * Description: com.dx.base.shiro.service.impl
 *
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/8
 */
@Service("MenuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<Menu> queryListParentId(String parentId, List<String> menuIdList) {
		List<Menu> menuList = queryListParentId(parentId);
		if(menuIdList == null){
			return menuList;
		}
		
		List<Menu> userMenuList = new ArrayList<>();
		for(Menu menu : menuList){
			if(menuIdList.contains(menu.getId())){
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	@Override
	public List<Menu> queryListParentId(String parentId) {
		return baseMapper.queryListParentId(parentId);
	}

	@Override
	public List<Menu> getUserMenuList(String username) {

		//用户菜单列表
		List<String> menuIdList = userService.queryUserMenuId(username);
		return getAllMenuList(menuIdList);
	}

	@Override
	public Set<String> getUserPermissions(String username) {

		//查询用户的所有权限
		List<String> permsList = userMapper.queryAllPerms(username);
		//用户权限列表
		Set<String> permsSet = new HashSet<>();
		for(String perms : permsList){
			if(StringUtils.isEmpty(perms)){
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}
		return permsSet;
	}

	/**
	 * 获取所有菜单列表
	 */
	private List<Menu> getAllMenuList(List<String> menuIdList){
		//查询根菜单列表
		List<Menu> menuList = queryListParentId("0", menuIdList);
		//递归获取子菜单
		getMenuTreeList(menuList, menuIdList);
		
		return menuList;
	}

	/**
	 * 递归
	 */
	private List<Menu> getMenuTreeList(List<Menu> menuList, List<String> menuIdList){
		List<Menu> subMenuList = new ArrayList<Menu>();
		
		for(Menu entity : menuList){
			//目录
			if(entity.getType() == Constant.MenuType.CATALOG.getValue()){
				entity.setList(getMenuTreeList(queryListParentId(entity.getId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}
		
		return subMenuList;
	}
}
