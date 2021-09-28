package com.xiaozhuo.hummer;

/**
 * @author huangjunqing 2021/9/28
 */
public interface Component<I, R> {

    void init(I initModel);

    void run(R runModel);

    void stop();

    void destroy();
}
