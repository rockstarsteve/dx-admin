package com.dx.base.security.bean;

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

    private static final long serialVersionUID = 1L;

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
        return restResult(null, 200, "ok");
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, 200, "ok");
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, 200, msg);
    }

    public static <T> R<T> error() {
        return restResult(null, 500, "failed");
    }

    public static <T> R<T> error(String msg) {
        return restResult(null, 500, msg);
    }

    public static <T> R<T> error(T data) {
        return restResult(data, 500, "failed");
    }

    public static <T> R<T> error(T data, String msg) {
        return restResult(data, 500, msg);
    }

    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R<T>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
