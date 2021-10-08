package com.xiaozhuo.hummer;

import lombok.Builder;
import lombok.Getter;

/**
 * @author xiaozhuo 2021/10/5 10:24
 */
@Builder
@Getter
public class AppContextConfig implements Config{
    /**
     * 扫描包在的位置
     */
    private String[] packageScans;

    public void validate() {
        //todo
    }
}
