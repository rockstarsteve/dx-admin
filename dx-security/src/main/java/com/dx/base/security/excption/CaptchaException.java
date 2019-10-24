package com.dx.base.security.excption;

/**
 * Description: com.dx.base.security.excption
 * 验证码错误异常类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/24
 */
public class CaptchaException extends RuntimeException {

    public CaptchaException() {
        super("user.jcaptcha.error", null);
    }
}
