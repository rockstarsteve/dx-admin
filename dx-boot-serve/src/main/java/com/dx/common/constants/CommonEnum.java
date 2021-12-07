package com.dx.common.constants;

/**
 * Description: com.dx.common.CommonEnum
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/13
 */
public enum CommonEnum {

    LOGIN_USER_KEY("login_user_key", "登录用户存token中的值"),
    LOGIN_USER_NAME("login_user_name", "登录用户存token中的值"),
    LOGIN_USER_ID("user_id", "登录用户id存token中的值"),
    TOKEN_PREFIX("Bearer ", "令牌前缀"),
    LOGIN_TOKEN_KEY("login_tokens", "登录用户 redis key");

    private final String value;
    private final String detail;

    private CommonEnum(String value, String detail) {
        this.value = value;
        this.detail = detail;
    }

    public String value() {
        return this.value;
    }

}
