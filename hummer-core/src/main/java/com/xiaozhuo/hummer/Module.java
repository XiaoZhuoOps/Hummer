package com.xiaozhuo.hummer;

import com.xiaozhuo.hummer.context.AppContext;

/**
 * @author huangjunqing 2021/9/28
 */
public interface Module {
    void load(AppContext appContext);
}
