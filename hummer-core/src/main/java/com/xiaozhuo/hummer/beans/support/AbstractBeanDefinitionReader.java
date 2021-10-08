package com.xiaozhuo.hummer.beans.support;

import com.xiaozhuo.hummer.AppContextConfig;
import com.xiaozhuo.hummer.BeansException;
import com.xiaozhuo.hummer.beans.config.BeanDefinition;
import com.xiaozhuo.hummer.beans.config.BeanDefinitionReader;
import com.xiaozhuo.hummer.beans.config.BeanDefinitionRegistry;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiaozhuo 2021/10/4 23:30
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    @Getter
    private BeanDefinitionRegistry beanDefinitionRegistry;

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return this.beanDefinitionRegistry;
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }
}
