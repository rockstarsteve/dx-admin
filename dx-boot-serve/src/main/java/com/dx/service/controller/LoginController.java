package com.dx.service.controller;

import com.dx.common.security.MyUserDetails;
import com.dx.common.security.TokenService;
import com.dx.util.AjaxResult;
import com.dx.service.entity.SysMenu;
import com.dx.service.entity.SysUser;
import com.dx.service.service.ISysMenuService;
import com.dx.service.service.LoginService;
import com.dx.service.service.impl.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Description: com.dx.sys.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/10
 */
@Api(tags = "系统登录的类")
@RestController
@RequestMapping("/system")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private SysPermissionService permissionService;
    @Autowired
    private ISysMenuService menuService;

    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody SysUser sysUser) {

        String token = loginService.login(sysUser);
        Map resultMap = new HashMap<>();
        resultMap.put("token", token);

        return AjaxResult.success(resultMap);
    }


    @ApiOperation(value = "获取用户信息", notes = "获取用户的user、roles、permissions信息")
    @PostMapping("/info")
    public AjaxResult info(HttpServletRequest request) {
        MyUserDetails loginUser = tokenService.getMyUserDetails(request);
        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        Map result = new HashMap();
        result.put("user", user);
        result.put("roles", roles);
        result.put("permissions", permissions);
        return AjaxResult.success(result);
    }

    @ApiOperation(value = "获取用户路由", notes = "获取用户的菜单栏")
    @PostMapping("/getRouters")
    public AjaxResult getRouters(HttpServletRequest request) {
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put("name","System");
//        objectObjectHashMap.put("path","/system");
//        objectObjectHashMap.put("hidden",false);
//        objectObjectHashMap.put("redirect","noRedirect");
//        objectObjectHashMap.put("component","Layout");
//        objectObjectHashMap.put("alwaysShow",true);
//
////        meta: { title: 'Example', icon: 'example' },
//        HashMap<Object, Object> objectObjectHashMap1 = new HashMap<>();
//        objectObjectHashMap1.put("title","Example");
//        objectObjectHashMap1.put("icon","example");
//        objectObjectHashMap.put("meta",objectObjectHashMap1);
//
////        objectObjectHashMap.put("children",null);
//
//        List resultList = new ArrayList();
//        resultList.add(objectObjectHashMap);







        MyUserDetails userDetails = tokenService.getLoginUser(request);
        // 用户信息
        SysUser user = userDetails.getUser();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getUserId());
        return AjaxResult.success(menuService.buildMenus(menus));
    }


    /**
     * 没用的接口，就为了给swagger展示这个接口而写的，最终调用的是secrity的这个接口
     *
     * @return
     */
    @ApiOperation(value = "退出登录", notes = "退出登录的说明")
    @PostMapping("/logout")
    public Object logout() {
        log.info("已经到了退出controller这里了。。。");
        return AjaxResult.success("退出成功！");
    }

}
