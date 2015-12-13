package com.wh.finaldemos.demos.touch;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.touch.touchtest.TouchTestDemo;

/**
 * Created by wanghui5-s on 2015/11/18.
 */
public class TouchDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            com.wh.finaldemos.demos.touch.touchdelegate.TouchDelegateDemo.class,
            TouchTestDemo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return TouchDemosListActivity.class;
    }
}
