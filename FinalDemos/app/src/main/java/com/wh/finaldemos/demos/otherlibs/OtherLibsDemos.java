package com.wh.finaldemos.demos.otherlibs;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.otherlibs.butterknife.ButterKnifeDemo;
import com.wh.finaldemos.demos.otherlibs.dagger2.Dagger2Demo;
import com.wh.finaldemos.demos.otherlibs.eventbus.EventBusDemo;
import com.wh.finaldemos.demos.otherlibs.guava.GuavaDemo;
import com.wh.finaldemos.demos.otherlibs.otto.OttoDemo;
import com.wh.finaldemos.demos.otherlibs.picasso.PicassoDemo;
import com.wh.finaldemos.demos.otherlibs.retrofit.RetrofitDemo;
import com.wh.finaldemos.demos.otherlibs.rxjava.RXDemo;

/**
 * Created by wanghui5-s on 2016/6/13.
 * <p/>
 * Conclusion:
 * #1:
 */
public class OtherLibsDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            ButterKnifeDemo.class,
            RetrofitDemo.class,
            RXDemo.class,
            OttoDemo.class,
            EventBusDemo.class,
            GuavaDemo.class,
            PicassoDemo.class,
            Dagger2Demo.class
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
