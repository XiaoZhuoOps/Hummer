package com.xiaozhuo.hummer.beans.config;

import com.xiaozhuo.hummer.BeansException;
import com.xiaozhuo.hummer.beans.BeanFactory;

/**
 * bean 创建钩子
 * @author xiaozhuo 2021/10/3 11:33
 */
public interface BeanPostProcessor {

    //为在Bean的初始化前提供回调入口
    default Object postProcessBeforeInitialization(Object bean, String beanName, BeanFactory beanFactory) throws BeansException {
        return bean;
    }

    //为在Bean的初始化之后提供回调入口
    default Object postProcessAfterInitialization(Object bean, String beanName, BeanFactory beanFactory) throws BeansException {
        return bean;
    }
}
