package com.wh.finaldemos.demos.customview.testcustomviewcallback;

import com.wh.finaldemos.Demo;
import com.whlib.alib.Log.XLog;

/**
 * Created by wanghui5-s on 2015/12/13.
 * <p/>
 * Conclusion:
 * #1:
 */
public class TestCustomViewCallbackDemo extends Demo {

    public static XLog logger = new XLog(TestCustomViewCallbackDemo.class);

    @Override
    public Class getLaunchActivityClass() {
        return TestCustomViewCallbackDemoActivity.class;
    }
}
