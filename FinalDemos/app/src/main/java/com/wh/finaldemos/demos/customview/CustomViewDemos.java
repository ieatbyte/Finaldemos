package com.wh.finaldemos.demos.customview;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.customview.testcustomshapeimageview.TestCustomShapeImageViewDemo;
import com.wh.finaldemos.demos.customview.testcustomviewcallback.TestCustomViewCallbackDemo;
import com.wh.finaldemos.demos.customview.testupcoverlayout.UpCoverLayoutUseDemo;

/**
 * Created by wanghui5-s on 2015/11/18.
 */
public class CustomViewDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            TestCustomShapeImageViewDemo.class,
            UpCoverLayoutUseDemo.class,
            TestCustomViewCallbackDemo.class
    };

    @Override
    public Class getLaunchActivityClass() {
        return CustomViewListActivity.class;
    }

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }
}
