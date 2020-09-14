package com.dx.sys.controller;

import com.dx.common.util.AjaxResult;
import com.dx.sys.entity.SysUser;
import com.dx.sys.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@Slf4j
public class LoginController {


    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Object login(SysUser sysUser) {

        String token = loginService.login(sysUser);

        return AjaxResult.success((Object) token);
    }

    /**
     * 没用的接口，就为了给swagger展示这个接口而写的，最终调用的是secrity的这个接口
     * @return
     */
    @PostMapping("/logout")
    public Object logout() {
        log.info("已经到了退出controller这里了。。。");
        return AjaxResult.success("退出成功！");
    }

}
