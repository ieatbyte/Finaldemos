package com.wh.finaldemos.demos.activity;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.activity.lifecycle.ActivityLifeCycleDemo;
import com.wh.finaldemos.demos.activity.taskandbackstack.TaskAndBackstackDemo;

/**
 * Created by wanghui5-s on 2015/12/13.
 * <p/>
 * Conclusion:
 * #1:
 */
public class ActivityDemos extends DemoGroup{

    private final Class[] demos = new Class[]{
            ActivityLifeCycleDemo.class,
            TaskAndBackstackDemo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return ActivityDemosActivity.class;
    }
}
