package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main;

/**
 * Created by wanghui on 17-3-16.
 */

public class GridListOneSpanItemVM<T extends BaseGridListItem> extends BaseGridListItemVM<T> {

    public GridListOneSpanItemVM(T gridItem) {
        super(gridItem);
    }

    @Override
    public int getSpanSize() {
        return 1;
    }
}
