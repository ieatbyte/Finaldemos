package com.wh.finaldemos.demos.androidviews.RecycleView.collapsable;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.FrameLayout;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

public class CollapseableDemoActivity extends BaseDemoActivity {

    private DockItemRecyclerView mList;

    private DemoCollapsableRVAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapseable_demo);

        mList = (DockItemRecyclerView) findViewById(R.id.list);
        mList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mAdapter = new DemoCollapsableRVAdapter();
        mList.setAdapter(mAdapter);
        mAdapter.buildDummyData();
        mList.setDockItemViewWrapper((FrameLayout) findViewById(R.id.list_dock_item));
    }
}
