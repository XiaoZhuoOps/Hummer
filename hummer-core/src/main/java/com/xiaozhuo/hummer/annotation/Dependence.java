package com.xiaozhuo.hummer.annotation;

import java.lang.annotation.*;

/**
 * 依赖注解
 * @author xiaozhuo 2021/10/4 23:07
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dependence {
    String name() default "";
}
