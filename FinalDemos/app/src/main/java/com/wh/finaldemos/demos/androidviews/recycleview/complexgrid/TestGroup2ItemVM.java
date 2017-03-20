package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestGroup2ItemVM extends GridSpannableOneSpanItemVM<TestGroup2Item> {

    public TestGroup2ItemVM(TestGroup2Item gridItem) {
        super(gridItem);
    }

    public String getTitle() {
        return gridItem.getTitle();
    }

    public int getIconDrawableId() {
        return gridItem.getIconDrawableId();
    }
}
