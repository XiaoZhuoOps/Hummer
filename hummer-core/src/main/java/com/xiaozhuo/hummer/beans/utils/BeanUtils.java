package com.xiaozhuo.hummer.beans.utils;

import java.lang.reflect.InvocationTargetException;

/**
 * bean 工具类
 * @author xiaozhuo 2021/10/3 15:56
 */
public class BeanUtils {

    /**
     * 给bean设置属性
     */
    public static void setProperty(Object bean, String name, Object value) throws IllegalAccessException, InvocationTargetException {
        org.apache.commons.beanutils.BeanUtils.setProperty(bean, name, value);
    }
}
