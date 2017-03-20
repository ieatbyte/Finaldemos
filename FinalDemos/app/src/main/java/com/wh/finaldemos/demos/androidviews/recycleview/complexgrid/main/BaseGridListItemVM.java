package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main;

/**
 * Created by wanghui on 17-3-16.
 */

public class BaseGridListItemVM<T extends BaseGridListItem> implements IGridListItemViewModel {

    protected T gridItem;

    public BaseGridListItemVM(T gridItem) {
        this.gridItem = gridItem;
    }

    @Override
    public int getSpanSize() {
        return 1;

    }

    @Override
    public long getItemId() {
        return gridItem != null ? gridItem.getItemId() : 0;
    }
}
