package com.wh.finaldemos.demos.textshow;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.textshow.Date.DateShowDemo;

/**
 * Created by wanghui5-s on 2015/12/19.
 * <p/>
 * Conclusion:
 * #1:
 */
public class TextShowDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            DateShowDemo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return TextShowDemosActivity.class;
    }
}
