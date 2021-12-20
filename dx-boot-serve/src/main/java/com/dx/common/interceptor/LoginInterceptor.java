package com.dx.common.interceptor;

import com.dx.common.security.TokenService;
import com.dx.sys.entity.SysUser;
import com.dx.util.AjaxResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description
 *
 * @author yaojian
 * @createTime 2021/12/07
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在执行controller方法(Handler)之前进行执行
        /**
         * 1. 需要判断 请求的接口路径 是否为 HandlerMethod (controller方法)
         * 2. 判断 token是否为空，如果为空 未登录
         * 3. 如果token 不为空，登录验证 loginService checkToken
         * 4. 如果认证成功 放行即可
         */
        if (!(handler instanceof HandlerMethod)) {
            //handler 可能是 RequestResourceHandler springboot 程序 访问静态资源 默认去classpath下的static目录去查询
            return true;
        }
        String token = request.getHeader("Authorization");

        log.info("=================>>>>>>>> request: " + request.getMethod() + "。URL:" + request.getRequestURI() + " 。token：" + token);

        if (!StringUtils.hasText(token)) {
            falseResult(response,"没有token");
            return false;
        }
        SysUser sysUser = tokenService.getUserDetails(request).getUser();
        if (sysUser == null) {
            falseResult(response,"用户不存在");
            return false;
        }
        //登录验证成功，放行
        return true;
    }

    public void falseResult(HttpServletResponse response,String info) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().println(objectMapper.writeValueAsString(AjaxResult.error(info)));
        return;
    }

}
