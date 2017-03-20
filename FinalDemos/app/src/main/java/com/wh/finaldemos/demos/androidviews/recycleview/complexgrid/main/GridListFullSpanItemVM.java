package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main;

import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.GridListConfig;

/**
 * Created by wanghui on 17-3-16.
 */

public class GridListFullSpanItemVM<T extends BaseGridListItem> extends BaseGridListItemVM<T> {

    public GridListFullSpanItemVM(T gridItem) {
        super(gridItem);
    }

    @Override
    public int getSpanSize() {
        return GridListConfig.TOTAL_SPAN_COUNT;
    }
}

