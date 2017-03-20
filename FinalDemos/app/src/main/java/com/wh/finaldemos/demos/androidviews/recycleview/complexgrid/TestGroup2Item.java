package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

/**
 * Created by wanghui on 17-3-20.
 */

public class TestGroup2Item extends BaseGridListItem {

    private String title;

    private int iconDrawableId;

    public TestGroup2Item(String title, int iconDrawableId) {
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
