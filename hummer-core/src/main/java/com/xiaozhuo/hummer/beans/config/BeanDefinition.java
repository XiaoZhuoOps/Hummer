package com.xiaozhuo.hummer.beans.config;

/**
 * bean 解析信息
 * @author xiaozhuo 2021/10/3 10:56
 */
public interface BeanDefinition {

    void setBeanClass(Class<?> beanClass);

    Class<?> getBeanClass();

    void addPropertyValue(PropertyValue propertyValue);

    PropertyValues getPropertyValues();
}
