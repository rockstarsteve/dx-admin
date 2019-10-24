package com.dx.base.security.controller;

import com.dx.base.security.bean.*;
import com.dx.base.security.service.SysMenuService;
import com.dx.base.security.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: com.dx.sys.controller
 * 登录模块
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/12
 */
@RestController
public class LoginController {

    @Autowired(required = false)
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenServiceImpl tokenService;
    @Autowired
    private SysMenuService menuService;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @GetMapping("/login")
    public Object login(String username, String password) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        LoginUser loginUser = (LoginUser)authenticate.getPrincipal();

        // 生成token
        String token = tokenService.createToken(loginUser);


        return R.ok(token);
    }


    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @RequestMapping("/getInfo")
    public R getInfo(HttpServletRequest request) {
        LoginUser loginUser = tokenService.getLoginUser(request);
        SysUser sysUser = loginUser.getSysUser();

        Map map = new HashMap();
        map.put("sysUser", sysUser);
        R.ok(map);

        return R.ok(map);
    }


    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @RequestMapping("getRouters")
    public R getRouters(HttpServletRequest request)
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        // 用户信息
        SysUser user = loginUser.getSysUser();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getUserId());

        List<RouterVo> routerVoList = menuService.buildMenus(menus);

        return R.ok(routerVoList);
    }


}
