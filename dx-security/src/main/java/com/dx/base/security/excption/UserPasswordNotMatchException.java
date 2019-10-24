package com.dx.base.security.excption;

/**
 * Description: com.dx.base.security.excption
 * 用户密码不正确或不符合规范异常类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/24
 */
public class UserPasswordNotMatchException extends RuntimeException {

    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
