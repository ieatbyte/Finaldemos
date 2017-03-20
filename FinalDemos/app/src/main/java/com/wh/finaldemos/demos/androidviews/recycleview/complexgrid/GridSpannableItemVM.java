package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

/**
 * Created by wanghui on 17-3-16.
 */

public class GridSpannableItemVM implements IGridItemViewModel{

    @Override
    public int getSpanSize() {
        return 1;

    }

    public long getItemId() {
        return this.hashCode();
    }
}
