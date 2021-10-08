package com.xiaozhuo.hummer.beans.support;

import com.xiaozhuo.hummer.BeansException;
import com.xiaozhuo.hummer.beans.BeanFactory;
import com.xiaozhuo.hummer.beans.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象工厂
 *
 * @author xiaozhuo 2021/10/3 11:44
 */
public abstract class AbstractBeanFactory implements BeanFactory, SingletonBeanRegistry {

    @Override
    public Object getBean(String name) throws BeansException {
        return getBean0(name);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return getBean0(name, args);
    }

    private Object getBean0(String name, Object... args) {
        Object singletonBean = getSingletonBean(name);
        if (singletonBean != null) {
            return singletonBean;
        }

        return createBean(name, args);
    }

    /* ============================ abstract ============================ */

    abstract Object createBean(String beanName, Object... args);

    /* ============================ SingletonBeanRegistry ============================ */

    Map<String, Object> singletonBeanMap = new HashMap<>();

    @Override
    public void registerSingletonBean(String beanName, Object bean) {
        singletonBeanMap.put(beanName, bean);
    }

    @Override
    public Object getSingletonBean(String beanName) {
        return singletonBeanMap.get(beanName);
    }
}
