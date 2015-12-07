package com.wh.finaldemos.demos.graphic2d;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.graphic2d.palletetest.PalleteCheckShineDemo;

/**
 * Created by wanghui5-s on 2015/12/7.
 * <p/>
 * Conclusion:
 * #1:
 */
public class Graphic2DDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            PalleteCheckShineDemo.class
    };

    @Override
    public Class getLaunchActivityClass() {
        return Graphic2DDemosListActivity.class;
    }

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }
}
