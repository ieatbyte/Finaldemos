package com.wh.finaldemos.demos.activity.lifecycle;

import com.wh.finaldemos.Demo;
import com.whlib.alib.Log.XLog;

/**
 * Created by wanghui5-s on 2015/12/13.
 * <p/>
 * Conclusion:
 * #1:
 */
public class ActivityLifeCycleDemo extends Demo {

    public static XLog logger = new XLog(ActivityLifeCycleDemo.class);

    @Override
    public Class getLaunchActivityClass() {
        return ActivityLifeCycleDemoActivity.class;
    }
}
