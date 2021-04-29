package com.dx.aop.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/04/14
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface AopAnno {

    String value();
}
