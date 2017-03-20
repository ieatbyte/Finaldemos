package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wh.finaldemos.R;

import butterknife.BindView;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestCell1ItemViewHolder extends GridSpannableItemViewHolder<TestGroup1ItemVM> {

    @BindView(R.id.item_title)
    TextView titleView;

    @BindView(R.id.item_logo)
    ImageView logoView;

    public TestCell1ItemViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(TestGroup1ItemVM item) {
        if (item instanceof TestGroup1ItemVM) {
            TestGroup1ItemVM realItem = (TestGroup1ItemVM)item;
            titleView.setText(realItem.getTitle());
            logoView.setImageResource(realItem.getIconDrawableId());
        }
    }
}
