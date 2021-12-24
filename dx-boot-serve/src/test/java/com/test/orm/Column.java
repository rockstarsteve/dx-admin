package com.test.orm;

import java.lang.annotation.*;

/**
 * description
 *
 * @author yaojian
 * @createTime 2021/12/24
 */
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {
    String value() default "";
}
