package com.dx.servicebase.exceptionhandler;

import com.dx.commonutils.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: com.dx.servicebase.exceptionhandler
 * 自定义全局处理异常类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/7/22
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String logExceptionFormat = "全局异常捕获信息: Code: %s Detail: %s";

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DxException.class)
    public AjaxResult RRExceptionHandler(DxException e) {
        log.info("错误位置：" + e);
        return AjaxResult.error(e.getCode(), e.getMsg());
    }

    /**
     * 一般运行时候异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public AjaxResult runtimeExceptionHandler(RuntimeException e) {
        log.info("错误位置：" + e);
        return resultFormatDefaultMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(), e);
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
        List<String> defaultMsg = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
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
        e.printStackTrace();
        log.error(String.format(logExceptionFormat, code, e.getMessage()));
        return AjaxResult.error(code, "系统出错，请联系管理员！");
    }

}
