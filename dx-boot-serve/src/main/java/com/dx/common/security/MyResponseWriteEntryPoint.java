package com.dx.common.security;

import com.dx.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
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
public class MyResponseWriteEntryPoint extends JsonResponseWrite implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        log.info("访问此资源需要完全身份验证（" + authException.getMessage() + "）！");
        authException.printStackTrace();
        //输出
        this.WriteJSON(request, response,
                //"访问此资源需要完全身份验证（" + authException.getMessage() + "）！"
                AjaxResult.error(501, "认证失败,请尝试重新登录！"));
    }
}
