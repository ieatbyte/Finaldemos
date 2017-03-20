package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.docktoprecyclerview.RecyclerViewDockTopHelper;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.TestGridListDemoAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class ComplexGridDemoActivityFragment extends Fragment {

    @BindView(R.id.listview)
    RecyclerView mListView;

    private View mRootView;

    private GridLayoutManager mLayoutManager;

    private TestGridListDemoAdapter mAdapter;

    private RecyclerViewDockTopHelper mRecyclerViewDockTopHelper;

    public ComplexGridDemoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_complex_grid_demo, container, false);
        ButterKnife.bind(this, mRootView);

        initView();
        return mRootView;
    }

    private void initView() {
        mLayoutManager = new GridLayoutManager(getContext(), GridListConfig.TOTAL_SPAN_COUNT, GridLayoutManager.VERTICAL, false);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.getItem(position).getSpanSize();
            }
        });
        //mLayoutManager.setAutoMeasureEnabled(true);
        mListView.setLayoutManager(mLayoutManager);
        mAdapter = new TestGridListDemoAdapter(getContext());
        mListView.setAdapter(mAdapter);
//        mListView.setItemViewCacheSize(2);
     //   mListView.getRecycledViewPool().setMaxRecycledViews(TestGridListDemoAdapter.VIEW_TYPE_CELL_HORIZON_LIST_INNER, 10);
        mRecyclerViewDockTopHelper = new RecyclerViewDockTopHelper(mListView, mAdapter);
        mRecyclerViewDockTopHelper.setDockItemViewWrapper((FrameLayout) mRootView.findViewById(R.id.list_dock_item));
    }
}
