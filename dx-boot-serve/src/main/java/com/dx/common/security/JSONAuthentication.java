package com.dx.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description: com.dx.common.auth
 * 封装输出JSON格式的类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/11
 */
public abstract class JSONAuthentication {

    /**
     * 输出JSON
     *
     * @param request
     * @param response
     * @param data
     * @throws IOException
     * @throws ServletException
     */
    protected void WriteJSON(HttpServletRequest request,
                             HttpServletResponse response,
                             Object data) throws IOException {
        //这里很重要，否则页面获取不到正常的JSON数据集
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST,GET");
        //输出JSON
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(data));
        out.flush();
        out.close();
    }
}
