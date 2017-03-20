package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestGroup1ItemVM extends GridSpannableOneSpanItemVM {

    private String title;

    private int iconDrawableId;

    public TestGroup1ItemVM(String title, int iconDrawableId) {
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
