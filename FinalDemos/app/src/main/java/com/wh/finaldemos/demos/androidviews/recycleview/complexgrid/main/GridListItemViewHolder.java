package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by wanghui on 17-3-16.
 */

public abstract class GridListItemViewHolder<T extends IGridListItemViewModel> extends RecyclerView.ViewHolder {

    protected View mItemView;

    protected IGridListAdapterContract mAdapter;

    public GridListItemViewHolder(View itemView, IGridListAdapterContract adapter) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mItemView = itemView;
        mAdapter = adapter;
    }

    public abstract void bind(T item);
}
