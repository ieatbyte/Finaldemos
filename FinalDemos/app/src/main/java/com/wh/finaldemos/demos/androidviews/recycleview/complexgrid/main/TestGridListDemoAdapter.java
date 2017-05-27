package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1.TestCell1Item;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1.TestCell1ItemVM;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1.TestCell1ItemViewHolder;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1.TestGroup1ItemVM;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1.TestGroup1ItemViewHolder;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2.TestCell2Item;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2.TestCell2ItemVM;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2.TestCell2ItemViewHolder;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2.TestGroup2ItemVM;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2.TestGroup2ItemViewHolder;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.innerhorizenlist.TestInnerHorizonListItemVM;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.innerhorizenlist.TestInnerHorizonListItemViewHolder;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestGridListDemoAdapter extends BaseGridListAdapter{

    public final static int VIEW_TYPE_SPLIT_1 = 0;
    public final static int VIEW_TYPE_SPLIT_2 = 1;
    public final static int VIEW_TYPE_CELL_1 = 2;
    public final static int VIEW_TYPE_CELL_2 = 3;
    public final static int VIEW_TYPE_CELL_HORIZON_LIST_INNER = 4;

    public TestGridListDemoAdapter(Context context) {
        super(context);
        gennerateDummyData();
    }

    @Override
    public int getItemViewType(int position) {
        IGridListItemViewModel item = mData.get(position);
        if (item instanceof TestGroup1ItemVM) {
            return VIEW_TYPE_SPLIT_1;
        } else if (item instanceof TestGroup2ItemVM) {
            return VIEW_TYPE_SPLIT_2;
        } else if (item instanceof TestCell1ItemVM) {
            return VIEW_TYPE_CELL_1;
        } else if (item instanceof TestCell2ItemVM) {
            return VIEW_TYPE_CELL_2;
        } else if (item instanceof TestInnerHorizonListItemVM) {
            return VIEW_TYPE_CELL_HORIZON_LIST_INNER;
        }
        return super.getItemViewType(position);
    }

    @Override
    public GridListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SPLIT_1) {
            return new TestGroup1ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.complext_grid_split_1_layout, parent, false), this);
        } else if (viewType == VIEW_TYPE_SPLIT_2) {
            return new TestGroup2ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.complext_grid_split_2_layout, parent, false), this);
        } else if (viewType == VIEW_TYPE_CELL_1) {
            return new TestCell1ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.complext_grid_cell_1_layout, parent, false), this);
        } else if (viewType == VIEW_TYPE_CELL_2) {
            return new TestCell2ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.complext_grid_cell_2_layout, parent, false), this);
        } else if (viewType == VIEW_TYPE_CELL_HORIZON_LIST_INNER) {
            return new TestInnerHorizonListItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.complex_grid_inner_list_item_layout, parent, false), this);
        }
        return null;
    }

    private void gennerateDummyData() {
        mData.add(new TestGroup1ItemVM("split 1"));
        mData.add(new TestCell1ItemVM(new TestCell1Item("1", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("2", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("3", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("4", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("5", R.drawable.lenna)));
        TestGroup2ItemVM group2 = new TestGroup2ItemVM("split 2", "2 title");
        mData.add(group2);
        group2.addSubVM(new TestCell2ItemVM(new TestCell2Item("5", R.mipmap.ic_launcher)));
        group2.addSubVM(new TestCell2ItemVM(new TestCell2Item("6", R.mipmap.ic_launcher)));
        group2.addSubVM(new TestCell2ItemVM(new TestCell2Item("7", R.mipmap.ic_launcher)));
        group2.addSubVM(new TestCell2ItemVM(new TestCell2Item("8", R.mipmap.ic_launcher)));
        group2.addSubVM(new TestCell2ItemVM(new TestCell2Item("9", R.mipmap.ic_launcher)));
        group2.addSubVM(new TestCell2ItemVM(new TestCell2Item("10", R.mipmap.ic_launcher)));
        group2.addSubVM(new TestCell2ItemVM(new TestCell2Item("11", R.mipmap.ic_launcher)));
        mData.addAll(group2.getSubVMs());
        mData.add(new TestInnerHorizonListItemVM(null));
        mData.add(new TestGroup1ItemVM("split 1"));
        mData.add(new TestCell1ItemVM(new TestCell1Item("1", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("2", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("3", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("4", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("5", R.drawable.lenna)));
        mData.add(new TestGroup2ItemVM("split 2", "2 title"));
        mData.add(new TestCell2ItemVM(new TestCell2Item("5", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("6", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("7", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("8", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("9", R.mipmap.ic_launcher)));
        mData.add(new TestInnerHorizonListItemVM(null));
        mData.add(new TestGroup1ItemVM("split 1"));
        mData.add(new TestCell1ItemVM(new TestCell1Item("1", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("2", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("3", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("4", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("5", R.drawable.lenna)));
        mData.add(new TestGroup2ItemVM("split 2", "2 title"));
        mData.add(new TestCell2ItemVM(new TestCell2Item("5", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("6", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("7", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("8", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("9", R.mipmap.ic_launcher)));
        mData.add(new TestInnerHorizonListItemVM(null));
        mData.add(new TestGroup1ItemVM("split 1"));
        mData.add(new TestCell1ItemVM(new TestCell1Item("1", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("2", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("3", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("4", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("5", R.drawable.lenna)));
        mData.add(new TestGroup2ItemVM("split 2", "2 title"));
        mData.add(new TestCell2ItemVM(new TestCell2Item("5", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("6", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("7", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("8", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("9", R.mipmap.ic_launcher)));
        mData.add(new TestInnerHorizonListItemVM(null));
        mData.add(new TestGroup1ItemVM("split 1"));
        mData.add(new TestCell1ItemVM(new TestCell1Item("1", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("2", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("3", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("4", R.drawable.lenna)));
        mData.add(new TestCell1ItemVM(new TestCell1Item("5", R.drawable.lenna)));
        mData.add(new TestGroup2ItemVM("split 2", "2 title"));
        mData.add(new TestCell2ItemVM(new TestCell2Item("5", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("6", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("7", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("8", R.mipmap.ic_launcher)));
        mData.add(new TestCell2ItemVM(new TestCell2Item("9", R.mipmap.ic_launcher)));
        mData.add(new TestInnerHorizonListItemVM(null));

    }

    @Override
    public RecyclerView.ViewHolder onCreateDockForPosition(ViewGroup dockWrapper, int position) {
        if (position < mData.size()) {
            if (mData.get(position) instanceof TestGroup1ItemVM) {
                return onCreateViewHolder(dockWrapper, VIEW_TYPE_SPLIT_1);
            } else if (mData.get(position) instanceof TestGroup2ItemVM) {
                return onCreateViewHolder(dockWrapper, VIEW_TYPE_SPLIT_2);
            } else {
                // empty
            }
        } else {
            // empty
        }
        return onCreateViewHolder(dockWrapper, VIEW_TYPE_SPLIT_1);
    }

    @Override
    public void onBindDockViewHolder(RecyclerView.ViewHolder vh) {

    }
}
