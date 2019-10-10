package com.dx.base.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Description: com.dx.base.filter
 *
 *
 *         还不知道是干什么的
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/6
 */
@Slf4j
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * 校验验证码
     * <p>
     * 原FormAuthenticationFilter的认证方法
     * 该方法会在realm前调用
     * 由于验证码是我们自己生成存在session里的，所以我们需要在登录时判断验证码是否成功就可用该方法
     * <p>
     * 验证码为空或验证成功 继续执行父类的onAccessDenied方法
     * 验证码不为空且验证失败，返回true则不再走realm,直接进控制器的login.do
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object map) throws Exception {

        log.info("进入了shiro 的自定义的拦截器中。。。。。");

        // 从session获取正确的验证码
        HttpSession session = ((HttpServletRequest) request).getSession();
        //
        request.setAttribute("rememberMe","123456");
        String randomcode = request.getParameter("rememberMe");
        //从session中取出验证码
        //String validateCode = (String) session.getAttribute("validateCode");
        //页面输入的验证码
        String validateCode = "123456";
        if (randomcode != null && validateCode != null) {
            if (!randomcode.equals(validateCode)) {
                //如果校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中
                request.setAttribute("shiroLoginFailure", "randomCodeError");
                //拒绝访问，不再校验账号和密码
                return true;
            }
        }
        return super.onAccessDenied(request, response, map);
    }

}
