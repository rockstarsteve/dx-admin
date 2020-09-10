package com.dx.common.filter;

import com.dx.common.exception.MyAuthenticationException;
import com.dx.sys.service.ISysUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Description: com.dx.common.filter
 * 身份认证拦截器
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/10
 */
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String MY_SECURITY_FORM_USERNAME_KEY = "username";
    public static final String MY_SECURITY_FORM_PASSWORD_KEY = "password";

    @Autowired
    ISysUserService sysUserService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {

            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            //取authenticationBean
            Map<String, String> authenticationBean = null;
            //用try with resource，方便自动释放资源
            try (InputStream is = request.getInputStream()) {
                authenticationBean = mapper.readValue(is, Map.class);
            } catch (IOException e) {
                //将异常放到自定义的异常类中
                throw new MyAuthenticationException(e.getMessage());
            }
            try {
                if (!authenticationBean.isEmpty()) {
                    //获得账号、密码
                    String username = authenticationBean.get(MY_SECURITY_FORM_USERNAME_KEY);
                    String password = authenticationBean.get(MY_SECURITY_FORM_PASSWORD_KEY);

                    //检测账号、密码是否存在
                    if (sysUserService.checkLogin(username, password)) {
                        //将账号、密码装入UsernamePasswordAuthenticationToken中
                        authRequest = new UsernamePasswordAuthenticationToken(username, password);
                        setDetails(request, authRequest);
                        return this.getAuthenticationManager().authenticate(authRequest);
                    }
                }
            } catch (Exception e) {
                throw new MyAuthenticationException(e.getMessage());
            }
            return null;
        } else if (request.getContentType().equals(MediaType.APPLICATION_FORM_URLENCODED_VALUE)) {

            String username = request.getParameter(MY_SECURITY_FORM_USERNAME_KEY);
            String password = request.getParameter(MY_SECURITY_FORM_PASSWORD_KEY);

            UsernamePasswordAuthenticationToken authRequest = null;

            try {
                //检测账号、密码是否存在
                if (sysUserService.checkLogin(username, password)) {
                    //将账号、密码装入UsernamePasswordAuthenticationToken中
                    authRequest = new UsernamePasswordAuthenticationToken(username, password);
                    setDetails(request, authRequest);
                    return this.getAuthenticationManager().authenticate(authRequest);
                }
            } catch (Exception e) {
                throw new MyAuthenticationException(e.getMessage());
            }

            return this.attemptAuthentication(request, response);
        } else {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
    }
}
