package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

/**
 * Created by wanghui on 17-3-16.
 */

public class GridSpannableOneSpanItemVM<T extends BaseGridListItem> extends BaseGridSpannableItemVM<T> {

    public GridSpannableOneSpanItemVM(T gridItem) {
        super(gridItem);
    }

    @Override
    public int getSpanSize() {
        return 1;
    }
}
