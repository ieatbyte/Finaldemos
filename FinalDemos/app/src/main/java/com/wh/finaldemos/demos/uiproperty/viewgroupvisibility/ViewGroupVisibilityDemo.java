package com.wh.finaldemos.demos.uiproperty.viewgroupvisibility;

import com.wh.finaldemos.Demo;

/**
 * Created by wanghui5-s on 2015/12/11.
 * <p/>
 * Conclusion:
 * #1: wrapper viewgroup visibility to gone, inner view will not get dispatched
 *     touch events
 */
public class ViewGroupVisibilityDemo extends Demo {

    @Override
    public Class getLaunchActivityClass() {
        return ViewGroupVisibilityDemoActivity.class;
    }
}
