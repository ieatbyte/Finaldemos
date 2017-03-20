package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2;

import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.GridListOneSpanItemVM;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestCell2ItemVM extends GridListOneSpanItemVM<TestCell2Item> {

    public TestCell2ItemVM(TestCell2Item gridItem) {
        super(gridItem);
    }

    public String getTitle() {
        return gridItem.getTitle();
    }

    public int getIconDrawableId() {
        return gridItem.getIconDrawableId();
    }
}
