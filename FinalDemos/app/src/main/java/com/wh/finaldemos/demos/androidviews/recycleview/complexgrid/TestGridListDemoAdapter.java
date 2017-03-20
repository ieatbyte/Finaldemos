package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.docktop.IDockTopRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestGridListDemoAdapter extends RecyclerView.Adapter<GridSpannableItemViewHolder> implements IDockTopRecyclerViewAdapter {

    public final static int VIEW_TYPE_SPLIT_1 = 0;
    public final static int VIEW_TYPE_SPLIT_2 = 1;
    public final static int VIEW_TYPE_CELL_1 = 2;
    public final static int VIEW_TYPE_CELL_2 = 3;
    public final static int VIEW_TYPE_CELL_HORIZON_LIST_INNER = 4;

    private ArrayList<IGridItemViewModel> mData;

    private Context mContext;

    public TestGridListDemoAdapter(Context context) {
        super();
        mContext = context;
        setHasStableIds(true);
        mData = new ArrayList<IGridItemViewModel>();
        gennerateDummyData();
    }

    @Override
    public long getItemId(int position) {
        return mData.get(position).getItemId();
    }

    @Override
    public int getItemViewType(int position) {
        IGridItemViewModel item = mData.get(position);
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

    public IGridItemViewModel getItem(int pos) {
        if (pos < mData.size() && pos >= 0) {
            return mData.get(pos);
        } else {
            return null;
        }
    }

    private void gennerateDummyData() {
        mData.add(new TestSplit1ItemVM("split 1"));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("1", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("2", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("3", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("4", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("5", R.drawable.lenna)));
        TestSplit2ItemVM group2 = new TestSplit2ItemVM("split 2", "2 title");
        mData.add(group2);
        group2.addSubVM(new TestGroup2ItemVM(new TestGroup2Item("5", R.mipmap.ic_launcher)));
        group2.addSubVM(new TestGroup2ItemVM(new TestGroup2Item("6", R.mipmap.ic_launcher)));
        group2.addSubVM(new TestGroup2ItemVM(new TestGroup2Item("7", R.mipmap.ic_launcher)));
        group2.addSubVM(new TestGroup2ItemVM(new TestGroup2Item("8", R.mipmap.ic_launcher)));
        group2.addSubVM(new TestGroup2ItemVM(new TestGroup2Item("9", R.mipmap.ic_launcher)));
        group2.addSubVM(new TestGroup2ItemVM(new TestGroup2Item("10", R.mipmap.ic_launcher)));
        group2.addSubVM(new TestGroup2ItemVM(new TestGroup2Item("11", R.mipmap.ic_launcher)));
        mData.addAll(group2.getSubVMs());
        mData.add(new TestInnerHorizonListItemVM(null));
        mData.add(new TestSplit1ItemVM("split 1"));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("1", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("2", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("3", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("4", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("5", R.drawable.lenna)));
        mData.add(new TestSplit2ItemVM("split 2", "2 title"));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("5", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("6", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("7", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("8", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("9", R.mipmap.ic_launcher)));
        mData.add(new TestInnerHorizonListItemVM(null));
        mData.add(new TestSplit1ItemVM("split 1"));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("1", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("2", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("3", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("4", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("5", R.drawable.lenna)));
        mData.add(new TestSplit2ItemVM("split 2", "2 title"));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("5", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("6", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("7", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("8", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("9", R.mipmap.ic_launcher)));
        mData.add(new TestInnerHorizonListItemVM(null));
        mData.add(new TestSplit1ItemVM("split 1"));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("1", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("2", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("3", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("4", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("5", R.drawable.lenna)));
        mData.add(new TestSplit2ItemVM("split 2", "2 title"));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("5", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("6", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("7", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("8", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("9", R.mipmap.ic_launcher)));
        mData.add(new TestInnerHorizonListItemVM(null));
        mData.add(new TestSplit1ItemVM("split 1"));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("1", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("2", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("3", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("4", R.drawable.lenna)));
        mData.add(new TestGroup1ItemVM(new TestGroup1Item("5", R.drawable.lenna)));
        mData.add(new TestSplit2ItemVM("split 2", "2 title"));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("5", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("6", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("7", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("8", R.mipmap.ic_launcher)));
        mData.add(new TestGroup2ItemVM(new TestGroup2Item("9", R.mipmap.ic_launcher)));
        mData.add(new TestInnerHorizonListItemVM(null));

    }

    @Override
    public boolean isDockAtPos(int pos) {
        if (pos < mData.size()) {
            return isDockHeaderItemViewModel(mData.get(pos));
        }
        return false;
    }

    @Override
    public int findCurrentDockItemPosInclude(int pos) {
        if (pos < mData.size()) {
            int i = pos;
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
    public int findNextDockItemPosExclude(int pos) {
        if (pos < mData.size()) {
            int i = pos + 1;
            while (i < mData.size()) {
                if (isDockHeaderItemViewModel(mData.get(i))) {
                    return i;
                }
                ++i;
            }
        }
        return 0;
    }

    private boolean isDockHeaderItemViewModel(IGridItemViewModel vm) {
        return vm instanceof GridSpannableHeaderDockItemVM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateDockForPos(ViewGroup dockWrapper, int pos) {
        if (pos < mData.size()) {
            if (mData.get(pos) instanceof TestSplit1ItemVM) {
                return onCreateViewHolder(dockWrapper, VIEW_TYPE_SPLIT_1);
            } else if (mData.get(pos) instanceof TestSplit2ItemVM) {
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
