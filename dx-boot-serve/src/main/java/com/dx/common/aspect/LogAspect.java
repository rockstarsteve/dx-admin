package com.dx.common.aspect;

import com.dx.common.annotation.Log;
import com.dx.common.util.HttpContextUtils;
import com.dx.common.util.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * description
 * 日志切面
 *
 * @author yaojian
 * @createTime 2021/12/07
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    //记录操作的日志的logger
    private static final Logger LOGGER = LoggerFactory.getLogger("operation-log");

    @Pointcut("@annotation(com.dx.common.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis(); // 记录开始时间
        Object result = point.proceed();        //执行原有方法
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //保存日志
        recordLog(point, time);
        return result;
    }

    private void recordLog(ProceedingJoinPoint joinPoint, long time) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log logAnnotation = method.getAnnotation(Log.class);
        LOGGER.info("=====================log start================================");
        LOGGER.info("module:{}", logAnnotation.module());
        LOGGER.info("operation:{}", logAnnotation.operator());

        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        LOGGER.info("request method:{}", className + "." + methodName + "()");

        // 请求的参数
        Object[] args = joinPoint.getArgs();
//        String params = JsonUtil.toJSONString(args);
        LOGGER.info("params:{}", args);

        // 获取request 设置IP地址
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        LOGGER.info("ip:{}", IPUtils.getIpAddr(request));
        LOGGER.info("url:{}", request.getRequestURI());
        // 记录执行时间
        LOGGER.info("excute time : {} ms", time);
        LOGGER.info("=====================log end================================");
    }

}
