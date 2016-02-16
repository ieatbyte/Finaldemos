package com.wh.finaldemos.demos.resource;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.resource.ResourceMatch.ResourceMatchDemo;

/**
 * Created by wanghui5-s on 2016/2/16.
 * <p/>
 * Conclusion:
 * #1:
 */
public class ResourceDemos extends DemoGroup{

    private final Class[] demos = new Class[]{
            ResourceMatchDemo.class,
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return ResourceDemosActivity.class;
    }
}
