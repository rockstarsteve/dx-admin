package com.dx.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
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
public class MyOncePerRequestFilter extends OncePerRequestFilter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    private String header = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String headerToken = request.getHeader(header);
        System.out.println("headerToken = " + headerToken);
        System.out.println("request getMethod = " + request.getMethod());


//        UserDetails userDetails = userDetailsService.loadUserByUsername("user");
//
//        // 将用户信息存入 authentication，方便后续校验
//        UsernamePasswordAuthenticationToken authentication =
//                new UsernamePasswordAuthenticationToken(
//                        userDetails,
//                        null,
//                        userDetails.getAuthorities()
//                );
//        //
//        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//        // 将 authentication 存入 ThreadLocal，方便后续获取用户信息
//        SecurityContextHolder.getContext().setAuthentication(authentication);


        chain.doFilter(request, response);
    }
}

