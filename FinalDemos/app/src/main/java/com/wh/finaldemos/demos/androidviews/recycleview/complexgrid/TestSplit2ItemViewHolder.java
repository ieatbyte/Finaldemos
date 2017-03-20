package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

import android.view.View;
import android.widget.TextView;

import com.wh.finaldemos.R;

import butterknife.BindView;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestSplit2ItemViewHolder extends GridSpannableItemViewHolder {

    @BindView(R.id.item_title)
    TextView titleView;

    @BindView(R.id.item_title2)
    TextView title2View;

    public TestSplit2ItemViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(GridSpannableItemVM item) {
        if (item instanceof TestSplit2ItemVM) {
            TestSplit2ItemVM realItem = (TestSplit2ItemVM)item;
            titleView.setText(realItem.getTitle1());
            title2View.setText(realItem.getTitle2());
        }
    }
}
