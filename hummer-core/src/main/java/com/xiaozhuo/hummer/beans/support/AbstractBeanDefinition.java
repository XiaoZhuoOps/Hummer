package com.xiaozhuo.hummer.beans.support;

import com.xiaozhuo.hummer.beans.config.BeanDefinition;
import com.xiaozhuo.hummer.beans.config.PropertyValue;
import com.xiaozhuo.hummer.beans.config.PropertyValues;

/**
 * bean 的配置信息
 * @author xiaozhuo 2021/10/3 13:35
 */
public abstract class AbstractBeanDefinition implements BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    @Override
    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public Class<?> getBeanClass() {
        return beanClass;
    }

    @Override
    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValues.addProperty(propertyValue);
    }

    @Override
    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public AbstractBeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }
}
