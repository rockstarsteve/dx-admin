package com.dx.common.exception;

import com.dx.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: com.dx.handler
 * <p>
 * ControllerAdvice注解只拦截Controller不会拦截Interceptor的异常
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/8
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DxException.class)
    public AjaxResult RRExceptionHandler(DxException e) {
        e.printStackTrace();
        return AjaxResult.error(e.getCode(), e.getMsg());
    }

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BadCredentialsException.class)
    public AjaxResult BadCredentialsExceptionHandler(BadCredentialsException e) {
        e.printStackTrace();
        return AjaxResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统出错，请联系管理员！");
    }

    /**
     * 一般运行时候异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public AjaxResult runtimeExceptionHandler(RuntimeException e) {
        e.printStackTrace();
        return resultFormatDefaultMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(), e);
    }

    /**
     * 没有权限访问异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public AjaxResult accessDeniedExceptionHandler(AccessDeniedException e) {
        e.printStackTrace();
        return AjaxResult.error(HttpStatus.FORBIDDEN.value(), "对不起，您没有权限访问！");
    }

    /**
     * 参数绑定时候抛出的异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public AjaxResult handleBindException(BindException ex) {
        log.error("参数校验异常", ex);
        List<String> defaultMsg = ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return AjaxResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), defaultMsg.get(0));
    }


    /**
     * 上传文件过大
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public AjaxResult maxUploadSizeExceededException(RuntimeException e) {
        log.info("上传文件过大，，错误位置：" + e);
        return AjaxResult.error("上传文件过大！请压缩文件！");
    }


    /**
     * 消息转换
     *
     * @param code
     * @param e
     * @param <T>
     * @return
     */
    private <T extends Throwable> AjaxResult resultFormat(Integer code, T e) {
        e.printStackTrace();
        log.error(String.format(logExceptionFormat, code, e.getMessage()));
        return AjaxResult.error(code, e.getMessage());
    }

    /**
     * 使用默认消息
     *
     * @param code
     * @param e
     * @param <T>
     * @return
     */
    private <T extends Throwable> AjaxResult resultFormatDefaultMsg(Integer code, T e) {
        //INFO 开发环境可以打开，生产环境不需要那么多日志
//        e.printStackTrace();
        log.error(String.format(logExceptionFormat, code, e.getMessage()));
        return AjaxResult.error(code, "系统出错，请联系管理员！");
    }

}
