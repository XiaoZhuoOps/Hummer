package com.xiaozhuo.hummer;

/**
 * 入口类
 */
public final class Hummer implements Component<Hummer.HummerInitModel, Hummer.HummerRunModel>{


    @Override
    public void init(HummerInitModel initModel) {
        //1、扫描和加载所有module

    }

    @Override
    public void run(HummerRunModel runModel) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    public static class HummerInitModel{

    }

    public static class HummerRunModel{

    }
}
