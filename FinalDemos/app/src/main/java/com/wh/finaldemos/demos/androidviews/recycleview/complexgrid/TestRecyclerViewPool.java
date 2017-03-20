package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

import android.support.v7.widget.RecyclerView;

/**
 * Created by wanghui on 17-3-17.
 */

public class TestRecyclerViewPool extends RecyclerView.RecycledViewPool {

//    LongSparseArray<TestInnerHorizonListItemViewHolder> horizonListScraps;
//
//    public TestRecyclerViewPool() {
//        super();
//        horizonListScraps = new LongSparseArray<TestInnerHorizonListItemViewHolder>();
//    }
//
//    @Override
//    public RecyclerView.ViewHolder getRecycledView(int viewType) {
//        if (viewType == TestGridListDemoAdapter.VIEW_TYPE_CELL_HORIZON_LIST_INNER) {
//            return horizonListScraps.get();
//        } else {
//            return super.getRecycledView(viewType);
//        }
//    }
//
//    @Override
//    public void putRecycledView(RecyclerView.ViewHolder scrap) {
//        final int viewType = scrap.getItemViewType();
//        if (viewType == TestGridListDemoAdapter.VIEW_TYPE_CELL_HORIZON_LIST_INNER) {
//            TestInnerHorizonListItemViewHolder realHolder = (TestInnerHorizonListItemViewHolder)scrap;
//            horizonListScraps.put(realHolder.getHItemId(), realHolder);
//        } else {
//            super.putRecycledView(scrap);
//        }
//    }
//
//    @Override
//    public void clear() {
//        super.clear();
//        horizonListScraps.clear();
//    }
}
