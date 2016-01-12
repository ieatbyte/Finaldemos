package com.wh.finaldemos.demos.animation;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.animation.normal.NormalAnimationDemo;

/**
 * Created by wanghui5-s on 2016/1/12.
 * <p/>
 * Conclusion:
 * #1:
 */
public class AnimationDemos extends DemoGroup {
    private final Class[] demos = new Class[]{
            NormalAnimationDemo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return AnimationDemosListActivity.class;
    }
}
