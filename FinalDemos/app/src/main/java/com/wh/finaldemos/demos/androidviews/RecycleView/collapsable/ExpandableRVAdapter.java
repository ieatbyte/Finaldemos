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
public abstract class ExpandableRVAdapter extends RecyclerView.Adapter {

    public final static int INVALID_POS = -1;

    protected ArrayList<Item> mData;

    public interface Callback {
        public void onExpand(ExpandableItem ci);

        public void onPreCollapse(ExpandableItem ci, int pos);

        public void onCollapse(ExpandableItem ci);
    }

    protected Callback mCallback;

    public ExpandableRVAdapter() {
        super();

        mData = new ArrayList<>();
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
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
        return mData.size();
    }

    public int findNextCollapsableItemPos(int pos) {
        if (pos < mData.size() - 1) {
            for (int i = pos + 1; i <= mData.size() - 1; ++i) {
                if (mData.get(i) instanceof ExpandableItem) {
                    return i;
                }
            }
        }
        return INVALID_POS;
    }

    public int findPreviousCollapsableItemPos(int pos) {
        if (pos < mData.size() - 1 && pos >= 0) {
            for (int i = pos - 1; i >= 0; --i) {
                if (mData.get(i) instanceof ExpandableItem) {
                    return i;
                }
            }
        }
        return INVALID_POS;
    }

    public void expandItem(ExpandableItem ci) {
        if (ci.expanded) {
            return;
        } else {
            ArrayList<ExpandableSubItem> subItems = ci.getSubItems();
            if (subItems != null && subItems.size() > 0) {
                Item current = ci;
                for (Item e : subItems) {
                    mData.add(mData.indexOf(current) + 1, e);
                    current = e;
                }
            }
            ci.expanded = true;
            notifyDataSetChanged();
            if (mCallback != null) {
                mCallback.onExpand(ci);
            }
        }
    }

    public void collapseItem(ExpandableItem ci) {
        if (!ci.expanded) {
            return;
        } else {
            if (mCallback != null) {
                mCallback.onPreCollapse(ci, mData.indexOf(ci));
            }
            ArrayList<ExpandableSubItem> subItems = ci.getSubItems();
            if (subItems != null && subItems.size() > 0) {
                mData.removeAll(subItems);
            }
            ci.expanded = false;
            notifyDataSetChanged();
            if (mCallback != null) {
                mCallback.onCollapse(ci);
            }
        }
    }

    public Item getItemAtPos(int position) {
        return position < mData.size() ? mData.get(position) : null;
    }

}
