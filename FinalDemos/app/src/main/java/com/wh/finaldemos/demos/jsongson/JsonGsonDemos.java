package com.wh.finaldemos.demos.jsongson;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.jsongson.basic.BasicDemo;

/**
 * Created by wanghui5-s on 2016/5/18.
 * <p/>
 * Conclusion:
 * #1:
 */
public class JsonGsonDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            BasicDemo.class,
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return JsonGsonDemosActivity.class;
    }
}
