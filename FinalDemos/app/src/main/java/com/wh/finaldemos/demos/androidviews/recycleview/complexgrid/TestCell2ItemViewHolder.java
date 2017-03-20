package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wh.finaldemos.R;

import butterknife.BindView;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestCell2ItemViewHolder extends GridSpannableItemViewHolder {

    @BindView(R.id.item_title)
    TextView titleView;

    @BindView(R.id.item_logo)
    ImageView logoView;

    public TestCell2ItemViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(GridSpannableItemVM item) {
        if (item instanceof TestGroup2ItemVM) {
            TestGroup2ItemVM realItem = (TestGroup2ItemVM)item;
            titleView.setText(realItem.getTitle());
            logoView.setImageResource(realItem.getIconDrawableId());
        }
    }
}
