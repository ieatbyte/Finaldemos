package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2;

import android.view.View;
import android.widget.TextView;

import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.GridListItemViewHolder;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.IGridListAdapterContract;

import butterknife.BindView;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestGroup2ItemViewHolder extends GridListItemViewHolder<TestGroup2ItemVM> {

    @BindView(R.id.item_title)
    TextView titleView;

    @BindView(R.id.item_title2)
    TextView title2View;

    public TestGroup2ItemViewHolder(View itemView, IGridListAdapterContract adapter) {
        super(itemView, adapter);
    }

    @Override
    public void bind(final TestGroup2ItemVM item) {
        titleView.setText(item.getTitle1());
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.addGroupSubItemVMs(item);
            }
        });
        title2View.setText(item.getTitle2());
        title2View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getSubVMs().size() > 0) {
                    //mAdapter.removeItems(item.getSubVMs());
                    mAdapter.removeGroupSubItemVMs(item);
                }
            }
        });
    }
}
