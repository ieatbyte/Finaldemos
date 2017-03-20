package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1;

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

public class TestCell1ItemViewHolder extends GridListItemViewHolder<TestCell1ItemVM> {

    @BindView(R.id.item_title)
    TextView titleView;

    @BindView(R.id.item_logo)
    ImageView logoView;

    public TestCell1ItemViewHolder(View itemView, IGridListAdapterContract adapter) {
        super(itemView, adapter);
    }

    @Override
    public void bind(TestCell1ItemVM item) {
        if (item instanceof TestCell1ItemVM) {
            TestCell1ItemVM realItem = (TestCell1ItemVM)item;
            titleView.setText(realItem.getTitle());
            logoView.setImageResource(realItem.getIconDrawableId());
        }
    }
}
