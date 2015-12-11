package com.wh.finaldemos.demos.androidviews;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.androidviews.CoordinatorLayout.CoordinatorLayoutDemos;
import com.wh.finaldemos.demos.androidviews.NestedScrollView.NestedScrollViewDemos;
import com.wh.finaldemos.demos.androidviews.RecycleView.RecyleViewDemos;

/**
 * Created by wanghui5-s on 2015/12/9.
 * <p/>
 * Conclusion:
 * #1:
 */
public class AndroidViewDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            NestedScrollViewDemos.class,
            RecyleViewDemos.class,
            CoordinatorLayoutDemos.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return AndroidViewDemosActivity.class;
    }
}
