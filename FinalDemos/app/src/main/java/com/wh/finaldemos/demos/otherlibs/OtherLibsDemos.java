package com.wh.finaldemos.demos.otherlibs;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.otherlibs.butterknife.ButterKnifeDemo;

/**
 * Created by wanghui5-s on 2016/6/13.
 * <p/>
 * Conclusion:
 * #1:
 */
public class OtherLibsDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            ButterKnifeDemo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return OtherLibsDemosListActivity.class;
    }
}
