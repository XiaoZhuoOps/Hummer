package com.xiaozhuo.hummer;

import com.xiaozhuo.hummer.beans.utils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author xiaozhuo 2021/10/4 21:07
 */
public class UtilsTest {

    @Test
    public void testBeanUtils() throws IllegalAccessException, NoSuchFieldException, InvocationTargetException {
        Foo foo = new Foo(1);
        BeanUtils.setProperty(foo, "a", 2);
        System.out.println(foo.a);
    }
}
