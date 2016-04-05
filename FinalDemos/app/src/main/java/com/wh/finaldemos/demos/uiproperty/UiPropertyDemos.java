package com.wh.finaldemos.demos.uiproperty;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.uiproperty.viewgroupvisibility.ViewGroupVisibilityDemo;
import com.wh.finaldemos.demos.uiproperty.wrapcotent_matchparent.WrapContentMatchParentDemo;

/**
 * Created by wanghui5-s on 2015/12/11.
 * <p/>
 * Conclusion:
 * #1:
 */
public class UiPropertyDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            ViewGroupVisibilityDemo.class,
            WrapContentMatchParentDemo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return UiPropertyDemosActivity.class;
    }
}
