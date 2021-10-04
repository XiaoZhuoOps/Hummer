package com.xiaozhuo.hummer.beans.config;

import com.xiaozhuo.hummer.BeansException;

/**
 * BeanDefinition 解析器
 * @author xiaozhuo 2021/10/3 11:08
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    void loadBeanDefinitions(String... locations) throws BeansException;
}
