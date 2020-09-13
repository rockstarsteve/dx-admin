package com.dx.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Description: com.dx.common.exception
 * 身份认证异常类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/10
 */
public class MyAuthenticationException extends AuthenticationException {

    public MyAuthenticationException(String msg) {
        super(msg);
    }

}
