package com.dx.base.shiro.controller;

import com.dx.base.shiro.bean.Menu;
import com.dx.base.shiro.service.MenuService;
import com.dx.base.util.R;
import com.dx.base.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Description: com.dx.bean
 * 系统菜单
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/8
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	/**
	 * 导航菜单
	 */
	@GetMapping("/nav")
	public R nav(){

		String username = (String)ShiroUtils.getSubject().getPrincipal();

		List<Menu> menuList = menuService.getUserMenuList(username);

		Set<String> permissions = menuService.getUserPermissions(username);

		return R.ok().put("menuList", menuList).put("permissions", permissions);
	}
	

}
