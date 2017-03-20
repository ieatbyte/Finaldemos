package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

/**
 * Created by wanghui on 17-3-16.
 */

public class GridSpannableFullSpanItemVM<T extends BaseGridListItem> extends BaseGridSpannableItemVM<T> {

    public GridSpannableFullSpanItemVM(T gridItem) {
        super(gridItem);
    }

    @Override
    public int getSpanSize() {
        return GridListConfig.TOTAL_SPAN_COUNT;
    }
}

