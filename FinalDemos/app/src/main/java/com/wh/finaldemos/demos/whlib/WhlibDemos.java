package com.wh.finaldemos.demos.whlib;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.whlib.testjlibrun.TestJlibRunDemo;

/**
 * Created by wanghui5-s on 2015/11/26.
 * <p/>
 * Conclusion:
 * #1:
 */
public class WhlibDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            TestJlibRunDemo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return WhlibDemosListActivity.class;
    }
}
