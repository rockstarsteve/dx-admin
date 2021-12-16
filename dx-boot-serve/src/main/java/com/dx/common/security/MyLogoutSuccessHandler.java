package com.dx.common.security;

import com.dx.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: com.dx.common.security
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/13
 */
@Component
@Slf4j
public class MyLogoutSuccessHandler extends JSONAuthentication implements LogoutSuccessHandler {

    @Autowired
    private TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {

        LoginUserDetails userDetails = tokenService.getUserDetails(request);
        if (userDetails != null) {
            String username = userDetails.getUsername();
            // 删除用户缓存记录
            tokenService.delUserDetails(userDetails.getUserKey());
            log.info("用户：" + username + "退出登录了");
        }
//        UserDetails user = (UserDetails) authentication.getPrincipal();
//        String username = user.getUsername();
        super.WriteJSON(request, response, AjaxResult.success("退出成功"));
    }
}
