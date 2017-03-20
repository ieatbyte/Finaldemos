package com.wh.finaldemos.demos.androidviews.recycleview.collapsable;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.FrameLayout;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

public class CollapseableDemoActivity extends BaseDemoActivity {

    private ExpandableDockTopRecyclerView mList;

    private DemoExpandableRVAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapseable_demo);

        mList = (ExpandableDockTopRecyclerView) findViewById(R.id.list);
        mList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mAdapter = new DemoExpandableRVAdapter();
        mList.setAdapter(mAdapter);
        mAdapter.buildDummyData();
        mList.setDockItemViewWrapper((FrameLayout) findViewById(R.id.list_dock_item));
    }
}
