package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

import android.view.View;
import android.widget.TextView;

import com.wh.finaldemos.R;

import butterknife.BindView;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestSplit1ItemViewHolder extends GridSpannableItemViewHolder<TestSplit1ItemVM> {

    @BindView(R.id.item_title)
    TextView titleView;

    public TestSplit1ItemViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(TestSplit1ItemVM item) {
        if (item instanceof TestSplit1ItemVM) {
            TestSplit1ItemVM realItem = (TestSplit1ItemVM)item;
            titleView.setText(realItem.getTitle1());
        }
    }
}
