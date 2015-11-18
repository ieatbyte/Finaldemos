package com.wh.finaldemos.demos.trys;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.trys.try1.Try1Demo;

/**
 * Created by wanghui5-s on 2015/11/18.
 */
public class TryDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            Try1Demo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return TryDemosListActivity.class;
    }
}
