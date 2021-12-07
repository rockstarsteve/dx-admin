package com.dx.common.annotation;


import java.lang.annotation.*;

/**
 * description
 * 日志
 *
 * @author yaojian
 * @createTime 2021/12/07
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 模块名称 默认为空
     */
    String module() default "";

    /**
     * 操作名称
     */
    String operator() default "";
}
