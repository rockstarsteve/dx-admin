package com.dx.sys.service.impl;

import com.dx.sys.entity.SysUser;
import com.dx.sys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Description: com.dx.sys.service.impl
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/13
 */
@Component
public class LoginSericeImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String login(SysUser sysUser) {

        Authentication authentication = null;

        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(sysUser.getUsername(), sysUser.getPassword()));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException){
                e.printStackTrace();
                throw new RuntimeException("账号密码错误");
            }else {
                throw new RuntimeException(e.getMessage());
            }
        }
        Object principal = authentication.getPrincipal();

        return "ok";
    }
}
