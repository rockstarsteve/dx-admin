package com.dx.base.common.bean;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description: com.dx.base.security.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/12
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private T data;

    public static <T> R<T> ok() {
        return restResult(200, "ok", null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(200, "ok", data);
    }

    public static <T> R<T> ok(String msg, T data) {
        return restResult(200, msg, data);
    }

    public static <T> R<T> ok(int code, String msg, T data) {
        return restResult(code, msg, data);
    }

    public static <T> R<T> error() {
        return restResult(500, "error", null);
    }

    public static <T> R<T> error(String msg) {
        return restResult(500, msg, null);
    }

    public static <T> R<T> error(T data) {
        return restResult(500, "error", data);
    }

    public static <T> R<T> error(String msg, T data) {
        return restResult(500, msg, data);
    }

    public static <T> R<T> error(int code, String msg, T data) {
        return restResult(code, msg, data);
    }

    private static <T> R<T> restResult(int code, String msg, T data) {
        R<T> apiResult = new R<T>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
