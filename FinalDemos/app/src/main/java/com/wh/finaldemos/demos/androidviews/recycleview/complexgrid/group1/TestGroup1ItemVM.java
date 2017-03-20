package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1;

import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.GridListGroupItemVM;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestGroup1ItemVM extends GridListGroupItemVM {

    private String title1;

    public TestGroup1ItemVM(String title1) {
        super(null);
        this.title1 = title1;
    }

    public String getTitle1() {
        return title1;
    }
}
