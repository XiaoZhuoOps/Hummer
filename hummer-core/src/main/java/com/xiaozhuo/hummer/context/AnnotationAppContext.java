package com.xiaozhuo.hummer.context;

import com.xiaozhuo.hummer.AppContextConfig;

/**
 * @author xiaozhuo 2021/10/5 10:29
 */
public class AnnotationAppContext extends AbstractAppContext{

    private AppContextConfig appContextConfig;

    public AnnotationAppContext(AppContextConfig appContextConfig) {
        this.appContextConfig = appContextConfig;
    }
}
