package com.dx.base.common.handler;

import com.dx.base.common.bean.R;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 运行时异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public R runtimeExceptionHandler(RuntimeException ex) {
        return resultFormat(5001, ex);
    }

    /**
     * 空指针异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public R nullPointerExceptionHandler(NullPointerException ex) {
        return resultFormat(5002, ex);
    }


    /**
     * 类型转换异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ClassCastException.class)
    public R classCastExceptionHandler(ClassCastException ex) {
        return resultFormat(5003, ex);
    }

    /**
     * IO异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(IOException.class)
    public R iOExceptionHandler(IOException ex) {
        return resultFormat(5004, ex);
    }

    /**
     * 未知方法异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(NoSuchMethodException.class)
    public R noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return resultFormat(5005, ex);
    }

    /**
     * 数组越界异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public R indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return resultFormat(5006, ex);
    }

    /**
     * 400错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public R requestNotReadable(HttpMessageNotReadableException ex) {
        System.out.println("400..requestNotReadable");
        return resultFormat(5007, ex);
    }

    /**
     * 400错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({TypeMismatchException.class})
    public R requestTypeMismatch(TypeMismatchException ex) {
        System.out.println("400..TypeMismatchException");
        return resultFormat(5008, ex);
    }

    /**
     * 400错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public R requestMissingServletRequest(MissingServletRequestParameterException ex) {
        System.out.println("400..MissingServletRequest");
        return resultFormat(5009, ex);
    }

    /**
     * 405错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public R request405(HttpRequestMethodNotSupportedException ex) {
        return resultFormat(50010, ex);
    }

    /**
     * 406错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public R request406(HttpMediaTypeNotAcceptableException ex) {
        System.out.println("406...");
        return resultFormat(50011, ex);
    }

    /**
     * 500错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public R server500(RuntimeException ex) {
        System.out.println("500...");
        return resultFormat(50012, ex);
    }

    /**
     * 栈溢出
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({StackOverflowError.class})
    public R requestStackOverflow(StackOverflowError ex) {
        return resultFormat(50013, ex);
    }

    /**
     * 其他错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({Exception.class})
    public R exception(Exception ex) {
        return resultFormat(50014, ex);
    }

    private <T extends Throwable> R resultFormat(Integer code, T ex) {
        ex.printStackTrace();
        log.error("错误码： " + code + "错误信息" + ex.getMessage());
        //记录错误码给后台排错用，前后端对接只用500来表示
        return R.error(500, ex.getMessage());
    }

}
