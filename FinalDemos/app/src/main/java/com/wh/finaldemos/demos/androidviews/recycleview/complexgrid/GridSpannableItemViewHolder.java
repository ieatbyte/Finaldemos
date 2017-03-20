package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by wanghui on 17-3-16.
 */

public abstract class GridSpannableItemViewHolder extends RecyclerView.ViewHolder {

    protected View mItemView;

    public GridSpannableItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mItemView = itemView;
    }

    public abstract void bind(GridSpannableItemVM item);
}
