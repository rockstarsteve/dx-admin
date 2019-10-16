package com.dx.base.security.controller;

import com.dx.base.security.bean.LoginUser;
import com.dx.base.security.bean.R;
import com.dx.base.security.service.RedisCache;
import com.dx.base.security.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    private RedisCache redisCache;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @GetMapping("/login")
    public Object login(String username, String password) {

        Authentication authenticate
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

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
        User user = loginUser.getUser();

        Map map = new HashMap();
        map.put("user", user);
        R.ok(map);

        return R.ok(map);
    }


}
