package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.docktop;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by wanghui on 17-3-20.
 */

public interface IDockTopRecyclerViewAdapter {

    boolean isDockAtPos(int pos);

    int findCurrentDockItemPosInclude(int pos);

    int findNextDockItemPosExclude(int pos);

    RecyclerView.ViewHolder onCreateDockForPos(ViewGroup dockWrapper, int pos);

    void onBindDockViewHolder(RecyclerView.ViewHolder vh);
}
