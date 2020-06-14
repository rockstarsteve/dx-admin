package com.dx.exception;

import com.dx.comm.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
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
    @ExceptionHandler(RRException.class)
    public AjaxResult RRExceptionHandler(RRException e) {
        log.info("错误位置：" + e);
        return AjaxResult.error(e.getCode(),e.getMsg());
    }

    /**
     * 一般的参数绑定时候抛出的异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public AjaxResult handleBindException(BindException ex){
        log.error(   "参数校验异常",ex);
        List<String> defaultMsg = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return AjaxResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), defaultMsg.get(0));
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
     *
     * 创建人 : yn
     * 创建时间 : 2020年5月30日 下午9:56:08
     * 描述 : 一般错误
     * 包名 : com.dx.exception
     * 方法名 : exception
     *  AjaxResult
     *  @throws
     */
    @ExceptionHandler(value = Exception.class)
	@ResponseBody
	public AjaxResult exception(HttpServletRequest req, Exception e) throws Exception {
    	log.info("错误位置：" + e);
    	if (e instanceof NoHandlerFoundException) {
			return AjaxResult.error("资源不存在");
		} else if (e instanceof HttpRequestMethodNotSupportedException) {
			return AjaxResult.error("不支持的请求类型");
		} else if (e instanceof IllegalArgumentException || e instanceof NumberFormatException
				|| e instanceof MethodArgumentTypeMismatchException || e instanceof HttpMessageNotReadableException
				|| e instanceof MissingServletRequestParameterException) {
			return AjaxResult.error("参数转换异常");
		} else if (e instanceof MethodArgumentNotValidException) {
			BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
			if (bindingResult.hasFieldErrors()) {
				String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
				return AjaxResult.error(defaultMessage);
			}
			return AjaxResult.error("参数校验异常");
		} else if (e instanceof MissingServletRequestParameterException) {
			String paramName = ((MissingServletRequestParameterException) e).getParameterName();
			return AjaxResult.error(paramName);
		} else if (e instanceof DuplicateKeyException) {
			return AjaxResult.error("主键或唯一键约束失败");
		} else {
			return AjaxResult.error(e.getMessage());
		}
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
