package com.wh.finaldemos.demos.androidviews.CoordinatorLayout;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.androidviews.CoordinatorLayout.custombehavior.CustomBehaviorDemo;
import com.wh.finaldemos.demos.androidviews.CoordinatorLayout.customcoordinator.CustomCoordinatorDemo;

/**
 * Created by wanghui5-s on 2015/12/10.
 * <p/>
 * Conclusion:
 * #1:
 */
public class CoordinatorLayoutDemos extends DemoGroup{

    private final Class[] demos = new Class[]{
            CustomBehaviorDemo.class,
            CustomCoordinatorDemo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return CoordinatorLayoutDemosActivity.class;
    }
}
