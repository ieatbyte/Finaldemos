package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1;

import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.BaseGridListItem;

/**
 * Created by wanghui on 17-3-20.
 */

public class TestCell1Item extends BaseGridListItem {

    private String title;

    private int iconDrawableId;

    public TestCell1Item(String title, int iconDrawableId) {
        this.title = title;
        this.iconDrawableId = iconDrawableId;
    }

    public String getTitle() {
        return title;
    }

    public int getIconDrawableId() {
        return iconDrawableId;
    }
}
