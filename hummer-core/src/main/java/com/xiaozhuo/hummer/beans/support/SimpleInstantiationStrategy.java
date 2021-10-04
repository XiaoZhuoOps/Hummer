package com.xiaozhuo.hummer.beans.support;

import com.xiaozhuo.hummer.BeansException;
import com.xiaozhuo.hummer.beans.config.BeanDefinition;
import com.xiaozhuo.hummer.beans.config.InstantiationStrategy;

import java.lang.reflect.Constructor;

/**
 * 基于JDK的实例化策略
 *
 * @author xiaozhuo 2021/10/3 14:12
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, Constructor constructor, Object... args) {
        Class<?> beanClass = beanDefinition.getBeanClass();

        try {
            if (constructor != null) {
                return constructor.newInstance(args);
            } else {
                return beanClass.newInstance();
            }
        } catch (Throwable e) {
            throw new BeansException("[SimpleInstantiationStrategy] new instance error！", e);
        }
    }
}
