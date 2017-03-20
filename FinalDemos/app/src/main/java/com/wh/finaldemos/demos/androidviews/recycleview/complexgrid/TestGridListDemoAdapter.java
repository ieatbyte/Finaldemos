package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wh.finaldemos.R;

import java.util.ArrayList;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestGridListDemoAdapter extends RecyclerView.Adapter<GridSpannableItemViewHolder> {

    public final static int VIEW_TYPE_SPLIT_1 = 0;
    public final static int VIEW_TYPE_SPLIT_2 = 1;
    public final static int VIEW_TYPE_CELL_1 = 2;
    public final static int VIEW_TYPE_CELL_2 = 3;
    public final static int VIEW_TYPE_CELL_HORIZON_LIST_INNER = 4;

    private ArrayList<GridSpannableItemVM> mData;

    private Context mContext;

    public TestGridListDemoAdapter(Context context) {
        super();
        mContext = context;
        setHasStableIds(true);
        mData = new ArrayList<GridSpannableItemVM>();
        gennerateDummyData();
    }

    @Override
    public long getItemId(int position) {
        return mData.get(position).getItemId();
    }

    @Override
    public int getItemViewType(int position) {
        GridSpannableItemVM item = mData.get(position);
        if (item instanceof TestSplit1ItemVM) {
            return VIEW_TYPE_SPLIT_1;
        } else if (item instanceof TestSplit2ItemVM) {
            return VIEW_TYPE_SPLIT_2;
        } else if (item instanceof TestGroup1ItemVM) {
            return VIEW_TYPE_CELL_1;
        } else if (item instanceof TestGroup2ItemVM) {
            return VIEW_TYPE_CELL_2;
        } else if (item instanceof TestInnerHorizonListItemVM) {
            return VIEW_TYPE_CELL_HORIZON_LIST_INNER;
        }
        return super.getItemViewType(position);
    }

    @Override
    public GridSpannableItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SPLIT_1) {
            return new TestSplit1ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.complext_grid_split_1_layout, parent, false));
        } else if (viewType == VIEW_TYPE_SPLIT_2) {
            return new TestSplit2ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.complext_grid_split_2_layout, parent, false));
        } else if (viewType == VIEW_TYPE_CELL_1) {
            return new TestCell1ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.complext_grid_cell_1_layout, parent, false));
        } else if (viewType == VIEW_TYPE_CELL_2) {
            return new TestCell2ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.complext_grid_cell_2_layout, parent, false));
        } else if (viewType == VIEW_TYPE_CELL_HORIZON_LIST_INNER) {
            return new TestInnerHorizonListItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.complex_grid_inner_list_item_layout, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(GridSpannableItemViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public GridSpannableItemVM getItem(int pos) {
        if (pos < mData.size() && pos >= 0) {
            return mData.get(pos);
        } else {
            return null;
        }
    }

    private void gennerateDummyData() {
        mData.add(new TestSplit1ItemVM("split 1"));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestSplit2ItemVM("split 2", "2 title"));
        mData.add(new TestGroup2ItemVM("5", R.mipmap.ic_launcher));
        mData.add(new TestGroup2ItemVM("6", R.mipmap.ic_launcher));
        mData.add(new TestGroup2ItemVM("7", R.mipmap.ic_launcher));
        mData.add(new TestGroup2ItemVM("8", R.mipmap.ic_launcher));
        mData.add(new TestGroup2ItemVM("9", R.mipmap.ic_launcher));
        mData.add(new TestInnerHorizonListItemVM());
        mData.add(new TestSplit1ItemVM("split 1"));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestSplit1ItemVM("split 1"));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestSplit2ItemVM("split 2", "2 title"));
        mData.add(new TestGroup2ItemVM("5", R.mipmap.ic_launcher));
        mData.add(new TestGroup2ItemVM("6", R.mipmap.ic_launcher));
        mData.add(new TestGroup2ItemVM("7", R.mipmap.ic_launcher));
        mData.add(new TestGroup2ItemVM("8", R.mipmap.ic_launcher));
        mData.add(new TestGroup2ItemVM("9", R.mipmap.ic_launcher));
        mData.add(new TestInnerHorizonListItemVM());
        mData.add(new TestSplit1ItemVM("split 1"));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));

        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));

        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("1", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("2", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("3", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("4", R.drawable.lenna));
        mData.add(new TestGroup1ItemVM("5", R.drawable.lenna));


    }
}
