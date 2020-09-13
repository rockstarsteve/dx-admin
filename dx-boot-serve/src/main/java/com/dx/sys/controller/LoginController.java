package com.dx.sys.controller;

import com.dx.sys.entity.SysUser;
import com.dx.sys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: com.dx.sys.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/10
 */
@RestController
public class LoginController {



    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public Object login(SysUser sysUser) {


        String token = loginService.login(sysUser);


        return token;
    }

}
