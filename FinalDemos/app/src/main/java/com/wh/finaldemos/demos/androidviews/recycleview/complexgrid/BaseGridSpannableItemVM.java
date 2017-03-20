package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

/**
 * Created by wanghui on 17-3-16.
 */

public class BaseGridSpannableItemVM<T extends BaseGridListItem> implements IGridItemViewModel{

    T gridItem;

    public BaseGridSpannableItemVM(T gridItem) {
        this.gridItem = gridItem;
    }

    @Override
    public int getSpanSize() {
        return 1;

    }

    @Override
    public long getItemId() {
        return gridItem.getItemId();
    }
}
