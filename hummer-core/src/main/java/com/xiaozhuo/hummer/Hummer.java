package com.xiaozhuo.hummer;

import com.xiaozhuo.hummer.context.AppContext;

/**
 * 入口类
 */
public final class Hummer {

    private AppContext appContext;

    public Hummer create(Config... configs) {
        for (Config config : configs) {
            config.load(appContext);
        }

        return this;
    }
}
