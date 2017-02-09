package com.wh.finaldemos.demos.system;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.system.notification.SendNotificationDemo;

/**
 * Created by wanghui on 17-2-9.
 */

public class SystemDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            SendNotificationDemo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return SystemDemosActivity.class;
    }
}
