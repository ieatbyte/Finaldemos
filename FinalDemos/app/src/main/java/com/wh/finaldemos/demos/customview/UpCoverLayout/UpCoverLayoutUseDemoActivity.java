package com.wh.finaldemos.demos.customview.UpCoverLayout;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.androidviews.RecycleView.adapters.SimpleAdapter;
import com.wh.finaldemos.demos.androidviews.RecycleView.decorations.SimpleDecoration;

public class UpCoverLayoutUseDemoActivity extends BaseDemoActivity implements AdapterView.OnItemClickListener{

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_cover_layout_use_demo);

        mRecyclerView = (RecyclerView) findViewById(R.id.upcover_nested_scrollivew);
        SimpleAdapter sa = new SimpleAdapter();
        sa.setItemCount(100);
        sa.setOnItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new SimpleDecoration());
        mRecyclerView.setAdapter(sa);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,
                "Clicked: " + position + ", index " + mRecyclerView.indexOfChild(view),
                Toast.LENGTH_SHORT).show();
    }
}
