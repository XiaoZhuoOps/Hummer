package com.xiaozhuo.hummer.annotation;

import java.lang.annotation.*;

/**
 * 注入注解
 * @author xiaozhuo 2021/10/4 23:09
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Inject {
    String name() default "";
}
