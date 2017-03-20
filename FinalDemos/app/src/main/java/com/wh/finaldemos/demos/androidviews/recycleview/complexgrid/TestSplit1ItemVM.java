package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestSplit1ItemVM extends GridSpannableSplitItemVM {

    private String title1;

    public TestSplit1ItemVM(String title1) {
        super(null);
        this.title1 = title1;
    }

    public String getTitle1() {
        return title1;
    }
}
