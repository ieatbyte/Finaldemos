package com.wh.finaldemos.demos.touch.touchdelegate;

import com.wh.finaldemos.Demo;

/**
 * Created by wanghui5-s on 2015/11/18.
 *
 * Conclusion:
 * #1: touch delegate work when only one view in a viewgroup, if there are two views in viewgroup,
 *     set touch delegate will not work.
 */
public class TouchDelegateDemo extends Demo {

    @Override
    public Class getLaunchActivityClass() {
        return TouchDelegateTestActivity.class;
    }
}
