//package com.dx.common.interceptor;
//
//import com.dx.common.security.TokenService;
//import com.dx.common.util.JsonUtil;
//import com.dx.common.util.UserThreadLocal;
//import com.dx.sys.entity.SysUser;
//import com.dx.sys.service.LoginService;
//import com.dx.util.AjaxResult;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Claims;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * description
// *
// * @author yaojian
// * @createTime 2021/12/07
// */
//@Component
//@Slf4j
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    private LoginService loginService;
//    @Autowired
//    private TokenService tokenService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //在执行controller方法(Handler)之前进行执行
//        /**
//         * 1. 需要判断 请求的接口路径 是否为 HandlerMethod (controller方法)
//         * 2. 判断 token是否为空，如果为空 未登录
//         * 3. 如果token 不为空，登录验证 loginService checkToken
//         * 4. 如果认证成功 放行即可
//         */
//        if (!(handler instanceof HandlerMethod)) {
//            //handler 可能是 RequestResourceHandler springboot 程序 访问静态资源 默认去classpath下的static目录去查询
//            return true;
//        }
//        String token = request.getHeader("Authorization");
//
//        log.info("=================request start===========================");
//        String requestURI = request.getRequestURI();
//        log.info("request uri:{}", requestURI);
//        log.info("request method:{}", request.getMethod());
//        log.info("token:{}", token);
//        log.info("=================request end===========================");
//
//
//        if (!StringUtils.hasText(token)) {
//
//            AjaxResult result = AjaxResult.error(HttpStatus.UNAUTHORIZED.value(), "未登录");
//            response.setContentType("application/json;charset=utf-8");
//            ObjectMapper objectMapper = new ObjectMapper();
//            response.getWriter().print(JsonUtil.toJSONString(result));
//            return false;
//        }
//        Claims claims = tokenService.parseToken(token);
//
//        SysUser sysUser = null;
//        if (sysUser == null) {
//            AjaxResult result = AjaxResult.error(HttpStatus.UNAUTHORIZED.value(), "未登录");
//            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().print(JsonUtil.toJSONString(result));
//            return false;
//        }
//        //登录验证成功，放行
//        //我希望在controller中 直接获取用户的信息 怎么获取?
//        UserThreadLocal.put(sysUser);
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        //如果不删除 ThreadLocal中用完的信息 会有内存泄漏的风险
//        UserThreadLocal.remove();
//    }
//}
