package com.wh.finaldemos.demos.textshow;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.textshow.Date.DateShowDemo;
import com.wh.finaldemos.demos.textshow.EnterSpace.EnterSpaceDemo;
import com.wh.finaldemos.demos.textshow.MaxLength.MaxLengthDemo;
import com.wh.finaldemos.demos.textshow.Path.PathShowDemo;
import com.wh.finaldemos.demos.textshow.StaticLayout.StaticLayoutDemo;
import com.wh.finaldemos.demos.textshow.SysInfo.SysInfoShowDemo;

/**
 * Created by wanghui5-s on 2015/12/19.
 * <p/>
 * Conclusion:
 * #1:
 */
public class TextShowDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            DateShowDemo.class,
            PathShowDemo.class,
            SysInfoShowDemo.class,
            EnterSpaceDemo.class,
            StaticLayoutDemo.class,
            MaxLengthDemo.class
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
