package com.test.orm;

import java.lang.annotation.*;

/**
 * description
 *
 * @author yaojian
 * @createTime 2021/12/24
 */
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    String value() default "";
}
