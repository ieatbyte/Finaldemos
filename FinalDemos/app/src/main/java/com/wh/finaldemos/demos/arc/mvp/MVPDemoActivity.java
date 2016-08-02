package com.wh.finaldemos.demos.arc.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wh.finaldemos.R;

import java.util.ArrayList;

public class MVPDemoActivity extends AppCompatActivity implements Demo1Contract.View {

    private Demo1Contract.Presenter mPresenter;

    private RecyclerView mListView;

    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpdemo);

        mListView = (RecyclerView)findViewById(R.id.recyclerview_simple_rv);
        mListView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SimpleAdapter(this);
        mAdapter.setItemCount(100);
        mListView.setAdapter(mAdapter);
        mPresenter = new Demo1Presenter(this);
        mPresenter.loadData();
    }

    @Override
    public void setData(ArrayList<String> data) {
        mAdapter.doAddDummy();
    }

    @Override
    public void setPresenter(Demo1Contract.Presenter presenter) {

    }
}
