package com.dx.base.security.excption;

/**
 * Description: com.dx.base.security.excption
 * 验证码失效异常类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/24
 */
public class CaptchaExpireException extends RuntimeException {

    public CaptchaExpireException() {
        super("user.jcaptcha.expire", null);
    }
}
