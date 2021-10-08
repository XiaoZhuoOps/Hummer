package com.xiaozhuo.hummer;

import com.xiaozhuo.hummer.annotation.Dependence;

/**
 * @author xiaozhuo 2021/10/4 23:12
 */
@Dependence(name = "bar")
public class Bar {
    public String toString() {
        return "bar";
    }
}
