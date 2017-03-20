package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1;

import android.view.View;
import android.widget.TextView;

import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.GridListItemViewHolder;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.IGridListAdapterContract;

import butterknife.BindView;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestGroup1ItemViewHolder extends GridListItemViewHolder<TestGroup1ItemVM> {

    @BindView(R.id.item_title)
    TextView titleView;

    public TestGroup1ItemViewHolder(View itemView, IGridListAdapterContract adapter) {
        super(itemView, adapter);
    }

    @Override
    public void bind(TestGroup1ItemVM item) {
        if (item instanceof TestGroup1ItemVM) {
            TestGroup1ItemVM realItem = (TestGroup1ItemVM)item;
            titleView.setText(realItem.getTitle1());
        }
    }
}
