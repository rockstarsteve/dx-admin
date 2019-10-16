package com.dx.base.shiro.controller;

import com.dx.base.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: com.dx.base.shiro.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/30
 */
@RestController
@RequestMapping("/shiro")
public class IndexController {

    @Autowired
    private UserService userService;


    /**
     * 跳转登录页面
     *
     * @return
     */
    @GetMapping("/toLogin")
    public String toLogin(){

        return "要进行登录的登录页面。login 页面";
    }

    /**
     * 登录
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/login")
    public String login(HttpServletRequest request,String username, String password){

        String result = "登录成功";

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            result = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
            result = "用户名/密码错误";
        } catch (AuthenticationException e) {
            //其他错误，比如锁定，如果想单独处理请单独catch处理
            result = "其他错误：" + e.getMessage();
        }

        return result;
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(String userName){

        return null;
    }

    @RequiresPermissions("user:add")
    @GetMapping("/get")
    public String get(){

        return "get ok ";
    }

}
