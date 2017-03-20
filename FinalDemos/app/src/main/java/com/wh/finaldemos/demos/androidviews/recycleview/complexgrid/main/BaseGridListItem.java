package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main;

/**
 * Created by wanghui on 17-3-20.
 */

public abstract class BaseGridListItem {

    public long getItemId() {
        return this.hashCode();
    }
}
