package com.wh.finaldemos.demos.androidviews.RecycleView.collapsable;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.wh.finaldemos.Item;

import java.util.ArrayList;

/**
 * Created by wanghui5-s on 2016/6/6.
 * <p/>
 * Conclusion:
 * #1:
 */
public class CollapsedListRVAdapter extends RecyclerView.Adapter {

    private ArrayList<Item> mData;

    public CollapsedListRVAdapter() {
        super();

        mData = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
