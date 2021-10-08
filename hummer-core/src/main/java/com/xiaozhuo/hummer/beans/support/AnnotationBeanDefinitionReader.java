package com.xiaozhuo.hummer.beans.support;

import com.xiaozhuo.hummer.AppContextConfig;
import com.xiaozhuo.hummer.BeansException;
import com.xiaozhuo.hummer.annotation.Dependence;
import com.xiaozhuo.hummer.annotation.Inject;
import com.xiaozhuo.hummer.beans.config.BeanDefinition;
import com.xiaozhuo.hummer.beans.config.BeanDefinitionRegistry;
import com.xiaozhuo.hummer.beans.config.PropertyValues;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaozhuo 2021/10/5 10:42
 */
public class AnnotationBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public AnnotationBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        super(beanDefinitionRegistry);
    }

    @Override
    public void loadBeanDefinitions(AppContextConfig appContextConfig) throws BeansException {
        //1、get package
        String[] packageScans = appContextConfig.getPackageScans();
        //2、do scan
        Map<String, BeanDefinition> beanDefinitionMap = scan(packageScans);
        //3、register
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            getBeanDefinitionRegistry().registerBeanDefinition(entry.getKey(), entry.getValue());
        }
    }

    private Map<String, BeanDefinition> scan(String[] packageScans) {
        Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
        for (String packageScan : packageScans) {
            doScan(packageScan, beanDefinitionMap);
        }
        return beanDefinitionMap;
    }

    private void doScan(String packageScan, Map<String, BeanDefinition> beanDefinitionMap) {
        URL url = this.getClass().getClassLoader().getResource("/" + packageScan.replaceAll("\\.", "/"));
        if (null == url) {
            return;
        }
        File dir = new File(url.getFile());
        File[] dirs = dir.listFiles();
        if (null == dirs) {
            return;
        }

        for (File file : dirs) {
            if (file.isDirectory()) {
                doScan(packageScan + "." + file.getName(), beanDefinitionMap);
            } else {
                try {
                    Class<?> beanClass = Class.forName(packageScan + "." + file.getName().replace(".class", "").trim());
                    if (beanClass.isAnnotationPresent(Dependence.class)) {
                        String nameFromAnnotation = getNameFromAnnotation(beanClass);
                        PropertyValues propertiesFromAnnotation = getPropertiesFromAnnotation(beanClass);
                        AnnotatedBeanDefinition annotatedBeanDefinition = new AnnotatedBeanDefinition(beanClass, propertiesFromAnnotation);

                        beanDefinitionMap.put(nameFromAnnotation, annotatedBeanDefinition);
                    }
                } catch (Throwable e) {
                    throw new BeansException("");
                }
            }
        }
    }

    private String getNameFromAnnotation(Class<?> beanClass) {
        Dependence dependence = beanClass.getAnnotation(Dependence.class);
        if ("".equals(dependence.name())) {
            beanClass.getAnnotatedInterfaces()

            return beanClass.getSimpleName();
        }
        return dependence.name();
    }

    private PropertyValues getPropertiesFromAnnotation(Class<?> beanClass) {
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                String name, value;
                Inject inject = field.getAnnotation(Inject.class);
                if ("".equals(inject.name())) {
                    name =
                }
            }
        }
    }
}
