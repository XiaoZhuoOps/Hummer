package com.xiaozhuo.hummer.beans.utils;

import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.Field;

/**
 * bean 工具类
 * @author xiaozhuo 2021/10/3 15:56
 */
public class BeanUtils {

    /**
     * 给bean设置属性
     */
    public static void setProperty(Object bean, String name, Object value) throws IllegalAccessException {
        Class<?> aClass = bean.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            if (field != null && field.getName().equals(name)) {
                field.setAccessible(true);
                field.set(bean, value);
                field.setAccessible(false);
                break;
            }
        }
    }
}
