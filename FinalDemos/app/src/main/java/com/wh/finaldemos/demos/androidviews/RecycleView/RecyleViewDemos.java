package com.wh.finaldemos.demos.androidviews.RecycleView;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.androidviews.RecycleView.collapsable.CollapsableDemo;
import com.wh.finaldemos.demos.androidviews.RecycleView.imageslider.ImageSliderDemo;
import com.wh.finaldemos.demos.androidviews.RecycleView.simpleuse.RecycleViewSimpleUseDemo;

/**
 * Created by wanghui5-s on 2015/12/9.
 * <p/>
 * Conclusion:
 * #1:
 */
public class RecyleViewDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            RecycleViewSimpleUseDemo.class, ImageSliderDemo.class, CollapsableDemo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return RecycleViewDemosActivity.class;
    }
}
