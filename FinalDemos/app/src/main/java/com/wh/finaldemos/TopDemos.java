package com.wh.finaldemos;

/**
 * Created by wanghui5-s on 2015/11/18.
 */
public class TopDemos extends DemoGroup {

    private final Class[] topDemos = new Class[] {
            com.wh.finaldemos.demos.touch.TouchDemos.class,
            com.wh.finaldemos.demos.trys.TryDemos.class,
            com.wh.finaldemos.demos.customview.CustomViewDemos.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return topDemos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return MainActivity.class;
    }
}
