package com.wh.finaldemos.demos.androidviews.recycleview;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.androidviews.recycleview.collapsable.CollapsableDemo;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.ComplexGridDemo;
import com.wh.finaldemos.demos.androidviews.recycleview.imageslider.ImageSliderDemo;
import com.wh.finaldemos.demos.androidviews.recycleview.simpleuse.RecycleViewSimpleUseDemo;
import com.wh.finaldemos.demos.androidviews.recycleview.superslim.SuperSLiMDemo;

/**
 * Created by wanghui5-s on 2015/12/9.
 * <p/>
 * Conclusion:
 * #1:
 */
public class RecyleViewDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            RecycleViewSimpleUseDemo.class, ImageSliderDemo.class, CollapsableDemo.class, ComplexGridDemo.class,
            SuperSLiMDemo.class
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
