package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

/**
 * Created by wanghui on 17-3-16.
 */

public class GridSpannableFullSpanItemVM extends GridSpannableItemVM {

    @Override
    public int getSpanSize() {
        return GridListConfig.TOTAL_SPAN_COUNT;
    }
}

