package com.xiaozhuo.hummer.beans.support;

import com.xiaozhuo.hummer.beans.config.PropertyValues;

/**
 * 基于注解的bean definition
 * @author xiaozhuo 2021/10/3 13:46
 */
public class AnnotatedBeanDefinition extends AbstractBeanDefinition{

    public AnnotatedBeanDefinition(Class beanClass, PropertyValues propertyValues) {
        super(beanClass, propertyValues);
    }
}
