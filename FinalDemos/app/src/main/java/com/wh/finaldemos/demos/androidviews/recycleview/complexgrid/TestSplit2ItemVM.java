package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestSplit2ItemVM extends GridSpannableSplitItemVM {

    private String title1;

    private String title2;

    public TestSplit2ItemVM(String title1, String title2) {
        super(null);
        this.title1 = title1;
        this.title2 = title2;
    }

    public String getTitle1() {
        return title1;
    }

    public String getTitle2() {
        return title2;
    }

}
