package com.xiaozhuo.hummer.beans.config;

import java.lang.reflect.Constructor;

/**
 * bean instantiate 策略
 * @author xiaozhuo 2021/10/3 14:01
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, Constructor constructor, Object... args);
}
