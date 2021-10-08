package com.xiaozhuo.hummer;

import com.xiaozhuo.hummer.context.AnnotationAppContext;
import com.xiaozhuo.hummer.context.AppContext;
import lombok.Builder;

/**
 * @author huangjunqing 2021/9/28
 */
@Builder
public class AppContextModule implements Module {

    private AppContextConfig appContextConfig;

    @Override
    public void load(AppContext context) {
        context = new AnnotationAppContext(appContextConfig);
    }
}
