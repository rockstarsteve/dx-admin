package com.dx.common.exception;

import org.springframework.security.access.AccessDeniedException;


/**
 * Description: com.dx.common.exception
 *
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/10
 */
public class MyaccessDeniedException extends AccessDeniedException {

    public MyaccessDeniedException(String msg) {
        super(msg);
    }
}
