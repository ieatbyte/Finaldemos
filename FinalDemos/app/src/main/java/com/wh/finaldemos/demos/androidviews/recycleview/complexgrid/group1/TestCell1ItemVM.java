package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1;

import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.GridListOneSpanItemVM;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestCell1ItemVM extends GridListOneSpanItemVM<TestCell1Item> {

    public TestCell1ItemVM(TestCell1Item gridItem) {
        super(gridItem);
    }

    public String getTitle() {
        return gridItem.getTitle();
    }

    public int getIconDrawableId() {
        return gridItem.getIconDrawableId();
    }
}
