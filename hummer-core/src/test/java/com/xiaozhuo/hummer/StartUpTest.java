package com.xiaozhuo.hummer;

import com.xiaozhuo.hummer.beans.support.AnnotatedBeanDefinition;
import com.xiaozhuo.hummer.beans.support.DefaultListableBeanFactory;
import com.xiaozhuo.hummer.beans.support.SimpleInstantiationStrategy;
import org.junit.Test;

public class StartUpTest {

    @Test
    public void testStart() {

//        Hummer hummer = new Hummer().create(
//                AppContextModule.builder()
//                        .beanFactory(new DefaultListableBeanFactory(new SimpleInstantiationStrategy()))
//                        .build()
//        );
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory(new SimpleInstantiationStrategy());

        AnnotatedBeanDefinition beanDefinition = new AnnotatedBeanDefinition();
        beanDefinition.setBeanClass(Foo.class);
        beanFactory.registerBeanDefinition("fooBean", beanDefinition);

        Foo fooBean = (Foo) beanFactory.getBean("fooBean", 2);
        System.out.println(fooBean.a);
    }
}

