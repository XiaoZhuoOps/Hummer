package com.xiaozhuo.hummer.beans.config;

/**
 * bean 引用
 * @author xiaozhuo 2021/10/3 15:48
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}