package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

import java.util.ArrayList;

/**
 * Created by wanghui on 17-3-16.
 */

public class GridSpannableSplitItemVM<T extends BaseGridListItem> extends GridSpannableHeaderDockItemVM<T> {

    private ArrayList<IGridItemViewModel> subVMs;

    public GridSpannableSplitItemVM(T gridItem) {
        super(gridItem);
    }

    @Override
    public long getItemId() {
        return this.hashCode();
    }

    public ArrayList<IGridItemViewModel> getSubVMs() {
        return subVMs;
    }

    public void addSubVM(IGridItemViewModel vm) {
        if (subVMs == null) {
            subVMs = new ArrayList<IGridItemViewModel>();
        }
        if (!subVMs.contains(vm)) {
            subVMs.add(vm);
        }
    }

    public void removeSubVM(IGridItemViewModel vm) {
        if (subVMs == null) {
            return;
        }
        subVMs.remove(vm);
    }

    public void clearSubVMs() {
        if (subVMs == null) {
            return;
        }
        subVMs.clear();
    }
}
