package com.wh.finaldemos.demos.androidviews.RecycleView.collapsable;

import com.wh.finaldemos.Item;

import java.util.ArrayList;

/**
 * Created by wanghui5-s on 2016/6/6.
 * <p/>
 * Conclusion:
 * #1:
 */
public class CollapsableItem extends Item{

    // mark expanded data
    public boolean expanded;

    private ArrayList<CollapsedItem> mSubItems;

    public CollapsableItem(int id, String title) {
        super(id, title);
    }

    public ArrayList<CollapsedItem> getSubItems() {
        return mSubItems;
    }

    public void addSubItems(ArrayList<CollapsedItem> toAdd, boolean clear) {
        if (mSubItems == null) {
            mSubItems = new ArrayList<>();
        }
        mSubItems.addAll(toAdd);
    }

}
