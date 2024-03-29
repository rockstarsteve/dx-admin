package com.dx.common.security;

import com.dx.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
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
 * @since 2020/9/14
 */
@Component
@Slf4j
public class MyAccessDeniedHandler extends JsonResponseWrite implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        accessDeniedException.printStackTrace();
        log.info(accessDeniedException.getMessage());
        this.WriteJSON(request, response, AjaxResult.error(HttpStatus.FORBIDDEN.value(), accessDeniedException.getMessage()));
    }
}
