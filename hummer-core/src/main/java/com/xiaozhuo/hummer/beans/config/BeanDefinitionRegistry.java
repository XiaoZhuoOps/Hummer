package com.xiaozhuo.hummer.beans.config;

/**
 * BeanDefinition 注册表
 * @author xiaozhuo 2021/10/3 11:05
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String beanName);
}
