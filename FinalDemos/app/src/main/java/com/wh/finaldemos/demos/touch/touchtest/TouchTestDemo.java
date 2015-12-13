package com.wh.finaldemos.demos.touch.touchtest;

import com.wh.finaldemos.Demo;
import com.whlib.alib.Log.XLog;

/**
 * Created by wanghui5-s on 2015/12/13.
 * <p/>
 * Conclusion:
 * #1: onInterceptTouchEvent > out side setOnTouchListener onTouch > inner onTouchEvent
 * #2: target view is self: 1) if child view onTouchEvent return false 2) if viewgroup
 *      onInterceptTouchEvent return true. both 1 and 2 says the viewgroup will be regard as
 *      a ordinary view.
 *      target view is child: 1) if child view onTouchEvent return true
 */
public class TouchTestDemo extends Demo {

    static XLog logger = new XLog(TouchTestDemo.class);

    @Override
    public Class getLaunchActivityClass() {
        return TouchTestDemoActivity.class;
    }
}
