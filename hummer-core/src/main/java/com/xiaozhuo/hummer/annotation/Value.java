package com.xiaozhuo.hummer.annotation;

import java.lang.annotation.*;

/**
 * 值 注解
 * @author xiaozhuo 2021/10/4 23:16
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    String value() default "";
}
