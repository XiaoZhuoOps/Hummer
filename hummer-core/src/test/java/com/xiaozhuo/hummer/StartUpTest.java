package com.xiaozhuo.hummer;

import com.xiaozhuo.hummer.beans.utils.BeanUtils;
import org.junit.Test;

public class StartUpTest {

    @Test
    public void testBeanUtils() {
        Foo foo = new Foo(1);
        try {
            BeanUtils.setProperty(foo, "a", 2);
            System.out.println(foo.a);
        } catch (Throwable e) {
            System.out.println("error!");
        }
    }
}

class Foo {
    int a;

    public Foo(int a) {
        this.a = a;
    }
}
