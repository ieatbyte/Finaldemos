package com.wh.finaldemos.demos.backgroundtask;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.backgroundtask.jobscheduler.JobSchedulerDemo;

/**
 * Created by wanghui5-s on 2016/9/2.
 * <p/>
 * Conclusion:
 * #1:
 */
public class BackgroundTaskDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            JobSchedulerDemo.class,
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return BackgroundTaskDemosActivity.class;
    }
}
