package com.wh.finaldemos;

import com.wh.finaldemos.demos.activity.ActivityDemos;
import com.wh.finaldemos.demos.animation.AnimationDemos;
import com.wh.finaldemos.demos.jsongson.JsonGsonDemos;
import com.wh.finaldemos.demos.resource.ResourceDemos;
import com.wh.finaldemos.demos.textshow.TextShowDemos;
import com.wh.finaldemos.demos.uiproperty.UiPropertyDemos;

/**
 * Created by wanghui5-s on 2015/11/18.
 */
public class TopDemos extends DemoGroup {

    private final Class[] topDemos = new Class[] {
            com.wh.finaldemos.demos.touch.TouchDemos.class,
            com.wh.finaldemos.demos.trys.TryDemos.class,
            com.wh.finaldemos.demos.customview.CustomViewDemos.class,
            com.wh.finaldemos.demos.whlib.WhlibDemos.class,
            com.wh.finaldemos.demos.graphic2d.Graphic2DDemos.class,
            com.wh.finaldemos.demos.media.MediaDemos.class,
            com.wh.finaldemos.demos.androidviews.AndroidViewDemos.class,
            UiPropertyDemos.class,
            ActivityDemos.class,
            TextShowDemos.class,
            AnimationDemos.class,
            ResourceDemos.class,
            JsonGsonDemos.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return topDemos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return MainActivity.class;
    }
}
