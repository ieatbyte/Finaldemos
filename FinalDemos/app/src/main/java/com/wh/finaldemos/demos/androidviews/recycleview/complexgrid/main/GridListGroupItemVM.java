package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main;

import java.util.ArrayList;

/**
 * Created by wanghui on 17-3-16.
 */

public class GridListGroupItemVM<T extends BaseGridListItem> extends GridListHeaderDockItemVM<T> {

    private ArrayList<IGridListItemViewModel> subVMs;

    public GridListGroupItemVM(T gridItem) {
        super(gridItem);
        subVMs = new ArrayList<IGridListItemViewModel>();
    }

    @Override
    public long getItemId() {
        return this.hashCode();
    }

    public ArrayList<IGridListItemViewModel> getSubVMs() {
        return subVMs;
    }

    public void addSubVM(IGridListItemViewModel vm) {
        if (!subVMs.contains(vm)) {
            subVMs.add(vm);
        }
    }

    public void removeSubVM(IGridListItemViewModel vm) {
        subVMs.remove(vm);
    }

    public void clearSubVMs() {
        subVMs.clear();
    }
}
