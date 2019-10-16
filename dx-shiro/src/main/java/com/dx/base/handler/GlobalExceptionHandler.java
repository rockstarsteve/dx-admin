package com.dx.base.handler;

import com.dx.base.util.R;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * Description: com.dx.handler
 *
 *
 *      统一异常处理
 *
 *
 *      ControllerAdvice注解只拦截Controller不会拦截Interceptor的异常
 *
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/8
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";

    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({UnauthorizedException.class})
    public R processUnauthenticatedException(UnauthorizedException ex) {
        return resultFormat(11, ex);
    }

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public R runtimeExceptionHandler(RuntimeException ex) {
        return resultFormat(1, ex);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public R nullPointerExceptionHandler(NullPointerException ex) {
        return resultFormat(2, ex);
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public R classCastExceptionHandler(ClassCastException ex) {
        return resultFormat(3, ex);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public R iOExceptionHandler(IOException ex) {
        return resultFormat(4, ex);
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public R noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return resultFormat(5, ex);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public R indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return resultFormat(6, ex);
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public R requestNotReadable(HttpMessageNotReadableException ex) {
        System.out.println("400..requestNotReadable");
        return resultFormat(7, ex);
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public R requestTypeMismatch(TypeMismatchException ex) {
        System.out.println("400..TypeMismatchException");
        return resultFormat(8, ex);
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public R requestMissingServletRequest(MissingServletRequestParameterException ex) {
        System.out.println("400..MissingServletRequest");
        return resultFormat(9, ex);
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public R request405(HttpRequestMethodNotSupportedException ex) {
        return resultFormat(10, ex);
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public R request406(HttpMediaTypeNotAcceptableException ex) {
        System.out.println("406...");
        return resultFormat(11, ex);
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public R server500(RuntimeException ex) {
        System.out.println("500...");
        return resultFormat(12, ex);
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public R requestStackOverflow(StackOverflowError ex) {
        return resultFormat(13, ex);
    }

    //其他错误
    @ExceptionHandler({Exception.class})
    public R exception(Exception ex) {
        return resultFormat(14, ex);
    }

    private <T extends Throwable> R resultFormat(Integer code, T ex) {
        ex.printStackTrace();
        log.error(String.format(logExceptionFormat, code, ex.getMessage()));

        return R.error(code, ex.getMessage());
    }

}
