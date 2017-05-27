package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.docktoprecyclerview.IDockTopRecyclerViewAdapterContract;

import java.util.ArrayList;

/**
 * Created by wanghui on 17-3-20.
 */

public abstract class BaseGridListAdapter extends RecyclerView.Adapter<GridListItemViewHolder> implements IDockTopRecyclerViewAdapterContract,
        IGridListAdapterContract {

    protected ArrayList<IGridListItemViewModel> mData;

    protected Context mContext;

    public BaseGridListAdapter(Context context) {
        super();
        mContext = context;
        setHasStableIds(true);
        mData = new ArrayList<IGridListItemViewModel>();
    }

    @Override
    public long getItemId(int position) {
        return mData.get(position).getItemId();
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
}
