package com.dx.sys.service.impl;

import com.dx.common.security.MyUserDetails;
import com.dx.common.security.TokenService;
import com.dx.sys.entity.SysUser;
import com.dx.sys.service.LoginService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class LoginSericeImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @Override
    public String login(SysUser sysUser) {

        Authentication authentication = null;

        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(sysUser.getUsername(), sysUser.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof BadCredentialsException) {
                throw new BadCredentialsException("账号密码错误");
            } else {
                throw new RuntimeException(e.getMessage());
            }
        }
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        log.info("principal: " + myUserDetails);
        //去除密码
        myUserDetails.getUser().setPassword("");
        String token = tokenService.createToken(myUserDetails);

        return token;
    }
}
