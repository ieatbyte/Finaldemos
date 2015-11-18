package com.wh.finaldemos.demos.customview;

import com.wh.finaldemos.DemoGroup;

/**
 * Created by wanghui5-s on 2015/11/18.
 */
public class CustomViewDemos extends DemoGroup {

    @Override
    public Class getLaunchActivityClass() {
        return CustomViewListActivity.class;
    }

    @Override
    public Class[] getSubDemoClasses() {
        return null;
    }
}
