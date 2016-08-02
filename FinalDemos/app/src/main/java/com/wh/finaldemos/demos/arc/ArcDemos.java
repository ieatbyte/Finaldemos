package com.wh.finaldemos.demos.arc;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.arc.mvp.MVPDemo;

/**
 * Created by wanghui5-s on 2016/8/2.
 * <p/>
 * Conclusion:
 * #1:
 */
public class ArcDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            MVPDemo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return ArcDemosListActivity.class;
    }
}
