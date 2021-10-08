package com.xiaozhuo.hummer;

import com.xiaozhuo.hummer.annotation.Dependence;
import com.xiaozhuo.hummer.annotation.Inject;
import com.xiaozhuo.hummer.annotation.Value;

/**
 * @author xiaozhuo 2021/10/4 21:08
 */

@Dependence(name = "foo")
public class Foo {

    @Inject(name = "bar")
    private Bar bar;

    @Value(value = "1")
    int a;

    public Foo(){
    }

    public Foo(int a) {
        this.a = a;
    }

    public String toString() {
        return (bar == null) ? "foo" : "bar" + "foo";
    }
}
