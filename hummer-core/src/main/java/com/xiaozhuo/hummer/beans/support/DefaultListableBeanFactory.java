package com.xiaozhuo.hummer.beans.support;

import com.xiaozhuo.hummer.BeansException;
import com.xiaozhuo.hummer.beans.config.*;
import com.xiaozhuo.hummer.beans.utils.BeanUtils;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * beanFactory 默认实现
 *
 * @author xiaozhuo 2021/10/3 11:52
 */
public class DefaultListableBeanFactory extends AbstractBeanFactory implements BeanDefinitionRegistry {

    @Override
    Object createBean(String beanName, Object... args) {
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Class<?> beanClass = beanDefinition.getBeanClass();
        Object bean = null;
        try {
            bean = instantiateBean(beanName, beanDefinition, args);
            applyPropertyValues(beanName, beanDefinition, bean);
        } catch (Throwable e) {
            throw new BeansException("[DefaultListableBeanFactory] createBean error!", e);
        }

        //缓存bean
        registerSingletonBean(beanName, bean);

        return bean;
    }

    Object instantiateBean(String beanName, BeanDefinition beanDefinition, Object... args) {
        Class<?> beanClass = beanDefinition.getBeanClass();

        //1、按照形参个数匹配得到构造器
        Constructor constructor = null;
        for (Constructor cstr : beanClass.getDeclaredConstructors()) {
            if (cstr != null && cstr.getParameterCount() == args.length) {
                constructor = cstr;
                break;
            }
        }

        //2、委托instantiationStrategy进行实例化
        return instantiationStrategy.instantiate(beanDefinition, constructor, args);
    }

    private void applyPropertyValues(String beanName, BeanDefinition beanDefinition, Object bean) {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        if (propertyValues != null) {
            for (PropertyValue pv : propertyValues.getPropertyValues()) {
                String name = pv.getName();
                Object value = pv.getValue();

                // 对于引用类型，需要从容器中获取bean对象再注入
                if (value instanceof BeanReference) {
                    value = getBean(((BeanReference) value).getBeanName());
                }
                try {
                    BeanUtils.setProperty(bean, pv.getName(), pv.getValue());
                } catch (Throwable e) {
                    throw new BeansException("[DefaultListableBeanFactory] setProperty error!", e);
                }
            }
        }
    }

    /* ============================ BeanDefinitionRegistry ============================ */

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    /* ============================ InstantiationStrategy ============================ */

    private InstantiationStrategy instantiationStrategy;

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }

    public DefaultListableBeanFactory(InstantiationStrategy instantiationStrategy) {
        super();
        this.instantiationStrategy = instantiationStrategy;
    }
}
