package com.wh.finaldemos.demos.androidviews.recycleview.docktoprecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public interface IDockTopRecyclerViewAdapterContract {

    boolean isDockItemAtPosition(int position);

    int findCurrentDockItemPositionInclude(int position);

    int findNextDockItemPositionExclude(int position);

    RecyclerView.ViewHolder onCreateDockForPosition(ViewGroup dockWrapper, int position);

    void onBindDockViewHolder(RecyclerView.ViewHolder vh);
}
