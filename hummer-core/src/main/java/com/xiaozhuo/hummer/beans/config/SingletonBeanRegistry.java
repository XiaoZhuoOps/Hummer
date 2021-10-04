package com.xiaozhuo.hummer.beans.config;

/**
 * @author xiaozhuo 2021/10/3 12:10
 */
public interface SingletonBeanRegistry {
    void registerSingletonBean(String beanName, Object bean);

    Object getSingletonBean(String beanName);
}
