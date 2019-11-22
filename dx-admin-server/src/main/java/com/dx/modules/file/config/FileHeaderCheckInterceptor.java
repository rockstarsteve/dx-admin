package com.dx.modules.file.config;

import com.dx.modules.file.util.FileHeaderHelper;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Description: com.dx.modules.file.config
 *  文件上传拦截器
 *
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/11/13
 */
public class FileHeaderCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 判断是否为文件上传请求
        if (request != null && request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> files = multipartRequest.getFileMap();
            Iterator<String> iterator = files.keySet().iterator();
            while (iterator.hasNext()) {
                String formKey = (String) iterator.next();
                MultipartFile multipartFile = multipartRequest.getFile(formKey);
                //String filename = multipartFile.getOriginalFilename();
                byte[] file = multipartFile.getBytes() ;

                ////获取字节流前8字节，差不多够了，不行再加
                int HEADER_LENGTH = 8 ;

                if(file.length>HEADER_LENGTH){
                    //转成16进制
                    StringBuilder sb = new StringBuilder();
                    for(int i=0;i<HEADER_LENGTH;i++){
                        int v = file[i] & 0xFF;
                        String hv = Integer.toHexString(v);
                        if (hv.length() < 2) {
                            sb.append(0);
                        }
                        sb.append(hv);
                    }


                    boolean isFound = false ;
                    String fileHead = sb.toString().toUpperCase() ;
                    List<String> headerList = FileHeaderHelper.getInstance().getHeaderList() ;
                    for(String header : headerList){
                        if(fileHead.startsWith(header)){
                            isFound = true ;
                            break ;
                        }
                    }
                    if(!isFound){
//                		throw new BaseRunException("上传文件有异常，已被系统禁止！") ;
                        System.out.println("----------上传文件有异常，已被系统禁止！头部信息："+fileHead);
                        response.setCharacterEncoding("UTF-8");
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter printWriter = response.getWriter();
                        printWriter.write("上传文件有异常，已被系统禁止！");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }



}
