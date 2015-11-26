package com.whlib.testjavalib;

/**
 * Created by wanghui5-s on 2015/11/25.
 *
 * Generally, one try is one java language point, grammar or technical point
 */
public interface ATry {

    void startTry();
    void outputConclusionIfTryDone(String... conclusions);
}
