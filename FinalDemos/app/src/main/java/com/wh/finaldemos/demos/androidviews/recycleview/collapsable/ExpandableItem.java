package com.wh.finaldemos.demos.androidviews.recycleview.collapsable;

import com.wh.finaldemos.Item;

import java.util.ArrayList;

/**
 * Created by wanghui5-s on 2016/6/6.
 * <p/>
 * Conclusion:
 * #1:
 */
public class ExpandableItem extends Item{

    // mark expanded data
    public boolean expanded;

    private ArrayList<ExpandableSubItem> mSubItems;

    public ExpandableItem(int id, String title) {
        super(id, title);
    }

    public ArrayList<ExpandableSubItem> getSubItems() {
        return mSubItems;
    }

    public void addSubItems(ArrayList<ExpandableSubItem> toAdd, boolean clear) {
        if (mSubItems == null) {
            mSubItems = new ArrayList<>();
        }
        mSubItems.addAll(toAdd);
    }

}
