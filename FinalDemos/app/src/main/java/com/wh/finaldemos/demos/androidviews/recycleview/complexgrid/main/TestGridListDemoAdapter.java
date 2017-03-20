package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.docktoprecyclerview.IDockTopRecyclerViewAdapterContract;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1.TestCell1ItemViewHolder;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1.TestCell1Item;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1.TestCell1ItemVM;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1.TestGroup1ItemVM;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group1.TestGroup1ItemViewHolder;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2.TestCell2ItemViewHolder;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2.TestCell2Item;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2.TestCell2ItemVM;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2.TestGroup2ItemVM;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.group2.TestGroup2ItemViewHolder;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.innerhorizenlist.TestInnerHorizonListItemVM;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.innerhorizenlist.TestInnerHorizonListItemViewHolder;

import java.util.ArrayList;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestGridListDemoAdapter extends RecyclerView.Adapter<GridListItemViewHolder> implements IDockTopRecyclerViewAdapterContract,
        IGridListAdapterContract{

    public final static int VIEW_TYPE_SPLIT_1 = 0;
    public final static int VIEW_TYPE_SPLIT_2 = 1;
    public final static int VIEW_TYPE_CELL_1 = 2;
    public final static int VIEW_TYPE_CELL_2 = 3;
    public final static int VIEW_TYPE_CELL_HORIZON_LIST_INNER = 4;

    private ArrayList<IGridListItemViewModel> mData;

    private Context mContext;

    public TestGridListDemoAdapter(Context context) {
        super();
        mContext = context;
        setHasStableIds(true);
        mData = new ArrayList<IGridListItemViewModel>();
        gennerateDummyData();
    }

    @Override
    public long getItemId(int position) {
        return mData.get(position).getItemId();
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

    @Override
    public void onBindViewHolder(GridListItemViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public IGridListItemViewModel getItem(int pos) {
        if (pos < mData.size() && pos >= 0) {
            return mData.get(pos);
        } else {
            return null;
        }
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
    public void removeItems(ArrayList<IGridListItemViewModel> vmsToRemove) {
        mData.removeAll(vmsToRemove);
        notifyDataSetChanged();
    }

    @Override
    public void removeGroupSubItemVMs(GridListGroupItemVM groupVM) {
        mData.removeAll(groupVM.getSubVMs());
        notifyDataSetChanged();
    }

    @Override
    public void addGroupSubItemVMs(GridListGroupItemVM groupVM) {
        if (mData.contains(groupVM) && groupVM.getSubVMs().size() > 0 && !mData.containsAll(groupVM.getSubVMs())) {
            mData.addAll(mData.indexOf(groupVM) + 1, groupVM.getSubVMs());
            notifyDataSetChanged();
        }
    }

    @Override
    public boolean isDockItemAtPosition(int position) {
        if (position < mData.size()) {
            return isDockHeaderItemViewModel(mData.get(position));
        }
        return false;
    }

    @Override
    public int findCurrentDockItemPositionInclude(int position) {
        if (position < mData.size()) {
            int i = position;
            while (i >= 0) {
                if (isDockHeaderItemViewModel(mData.get(i))) {
                    return i;
                }
                --i;
            }
        }
        return 0;
    }

    @Override
    public int findNextDockItemPositionExclude(int position) {
        if (position < mData.size()) {
            int i = position + 1;
            while (i < mData.size()) {
                if (isDockHeaderItemViewModel(mData.get(i))) {
                    return i;
                }
                ++i;
            }
        }
        return 0;
    }

    private boolean isDockHeaderItemViewModel(IGridListItemViewModel vm) {
        return vm instanceof GridListHeaderDockItemVM;
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
