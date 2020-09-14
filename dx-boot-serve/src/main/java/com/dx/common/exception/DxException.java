package com.dx.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: com.dx.exception
 * 自定义异常运行时异常
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/3/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DxException extends RuntimeException {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String msg;

    public DxException(String message) {
        this.msg = message;
    }

    public DxException(String message, Integer code) {
        this.msg = message;
        this.code = code;
    }

    public DxException(String message, Throwable e) {
        super(message, e);
        this.msg = message;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

}
