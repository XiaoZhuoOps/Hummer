package com.xiaozhuo.hummer;

import java.beans.Beans;

/**
 * @author xiaozhuo
 * @date 2021/10/2 19:08
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
