package com.dx.base.security.service.impl;

import com.dx.base.security.bean.Constants;
import com.dx.base.security.bean.LoginUser;
import com.dx.base.security.excption.CaptchaException;
import com.dx.base.security.excption.CaptchaExpireException;
import com.dx.base.security.excption.UserPasswordNotMatchException;
import com.dx.base.security.service.CaptchaCacheService;
import com.dx.base.security.service.SysLoginService;
import com.dx.base.security.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Description: com.dx.base.security.service.impl
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/24
 */
@Service
public class SysLoginServiceImpl implements SysLoginService {


    @Autowired
    private CaptchaCacheService captchaCacheService;
    //TODO 去掉2019-10-24？？
    @Autowired(required = false)
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenServiceImpl tokenService;

    @Override
    public String login(String username, String password, String code, String uuid) {
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = captchaCacheService.getVerifyCode(verifyKey, null);
        if (captcha == null) {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha)) {
            throw new CaptchaException();
        }
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new UserPasswordNotMatchException();
            } else {
                throw new RuntimeException(e.getMessage());
            }
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 生成token
        return tokenService.createToken(loginUser);
    }
}
