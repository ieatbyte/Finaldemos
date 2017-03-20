package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestGroup1ItemVM extends GridSpannableOneSpanItemVM<TestGroup1Item> {

    public TestGroup1ItemVM(TestGroup1Item gridItem) {
        super(gridItem);
    }

    public String getTitle() {
        return gridItem.getTitle();
    }

    public int getIconDrawableId() {
        return gridItem.getIconDrawableId();
    }
}
