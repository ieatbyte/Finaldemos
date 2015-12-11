package com.wh.finaldemos.demos.androidviews.NestedScrollView.simpleuse;

import com.wh.finaldemos.Demo;

/**
 * Created by wanghui5-s on 2015/12/9.
 * <p/>
 * Conclusion:
 * #1: To make nested scroll work, it must be a NestedScrollingParent wrap a NestedScrollingChild
 *     NestedScrollingParent: CoordinatorLayoutDemos, NestedScrollView, SwipeRefreshLayout
 *     NestedScrollingChild: HorizontalGridView, NestedScrollView, RecyclerView, SwipeRefreshLayout, VerticalGridView
 *
 *     NestedScrollView, SwipeRefreshLayout is both NestedScrollingParent and NestedScrollingChild, so they can implement recursive wrapping
 */
public class NestedScrollViewSimpleUseDemo extends Demo {

    @Override
    public Class getLaunchActivityClass() {
        return NestedScrollViewSimpeUseDemoActivity.class;
    }
}
