package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.GridListItemViewHolder;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.IGridListAdapterContract;

import butterknife.BindView;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestCell2ItemViewHolder extends GridListItemViewHolder<TestCell2ItemVM> {

    @BindView(R.id.item_title)
    TextView titleView;

    @BindView(R.id.item_logo)
    ImageView logoView;

    public TestCell2ItemViewHolder(View itemView, IGridListAdapterContract adapter) {
        super(itemView, adapter);
    }

    @Override
    public void bind(TestCell2ItemVM item) {
        TestCell2ItemVM realItem = (TestCell2ItemVM) item;
        titleView.setText(realItem.getTitle());
        logoView.setImageResource(realItem.getIconDrawableId());
    }
}
