package com.wh.finaldemos.demos.androidviews.NestedScrollView;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.androidviews.NestedScrollView.simpleuse.NestedScrollViewSimpleUseDemo;

/**
 * Created by wanghui5-s on 2015/12/9.
 * <p/>
 * Conclusion:
 * #1:
 */
public class NestedScrollViewDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            NestedScrollViewSimpleUseDemo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return NestedScrollViewDemosActivity.class;
    }
}
