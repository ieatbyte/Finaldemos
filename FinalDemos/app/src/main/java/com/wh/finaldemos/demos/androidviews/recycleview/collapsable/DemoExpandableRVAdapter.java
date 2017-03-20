package com.wh.finaldemos.demos.androidviews.recycleview.collapsable;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wh.finaldemos.Item;
import com.wh.finaldemos.R;

import java.util.ArrayList;

/**
 * Created by wanghui5-s on 2016/6/6.
 * <p/>
 * Conclusion:
 * #1:
 */
public class DemoExpandableRVAdapter extends ExpandableRVAdapter {

    public final static int VIEW_TYPE_COLLAPSABLE = 0;
    public final static int VIEW_TYPE_COLLAPSED_TEXT = 1;
    public final static int VIEW_TYPE_COLLAPSED_IMAGE = 2;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Item item = mData.get(position);
        if (holder instanceof CollapsableItemViewHolder) {
            final DemoExpandableItem realItem = (DemoExpandableItem)item;
            ((CollapsableItemViewHolder) holder).titleView.setText("DemoExpandableItem" + position + ", " + realItem.title + ", expanded:" + realItem.expanded);
            ((CollapsableItemViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (realItem.expanded) {
                        collapseItem(realItem);
                    } else {
                        expandItem(realItem);
                    }
                }
            });
        } else if (holder instanceof CollapsedTextItemViewHolder) {
            DemoExpandableSubItemText realItem = (DemoExpandableSubItemText)item;
            ((CollapsedTextItemViewHolder) holder).titleView.setText("DemoExpandableSubItemText" + position + ", " + realItem.title);
        } else if (holder instanceof CollapsedImageItemViewHolder) {
            DemoExpandableSubItemImage realItem = (DemoExpandableSubItemImage)item;
            ((CollapsedImageItemViewHolder) holder).titleView.setText("DemoExpandableSubItemImage" + position + ", " + realItem.title);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_COLLAPSABLE) {
            return new CollapsableItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_collapsable_rv_adapter_collapsable_item_layout, parent, false));
        } else if (viewType == VIEW_TYPE_COLLAPSED_TEXT) {
            return new CollapsedTextItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_collapsable_rv_adapter_collapsed_item_text, parent, false));
        } else if (viewType == VIEW_TYPE_COLLAPSED_IMAGE) {
            return new CollapsedImageItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_collapsable_rv_adapter_collapsed_item_image, parent, false));
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public int getItemViewType(int position) {
        Item item = mData.get(position);
        if (item instanceof ExpandableItem) {
            return VIEW_TYPE_COLLAPSABLE;
        } else if (item instanceof DemoExpandableSubItemText) {
            return VIEW_TYPE_COLLAPSED_TEXT;
        } else if (item instanceof DemoExpandableSubItemImage) {
            return VIEW_TYPE_COLLAPSED_IMAGE;
        } else {
            throw new RuntimeException();
        }
    }

    public static class CollapsableItemViewHolder extends RecyclerView.ViewHolder {

        private TextView titleView;

        public CollapsableItemViewHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public static class CollapsedTextItemViewHolder extends RecyclerView.ViewHolder {

        private TextView titleView;

        public CollapsedTextItemViewHolder(View itemView) {
            super(itemView);

            titleView = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public static class CollapsedImageItemViewHolder extends RecyclerView.ViewHolder {

        private TextView titleView;

        public CollapsedImageItemViewHolder(View itemView) {
            super(itemView);

            titleView = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public void buildDummyData() {
        mData.clear();
        DemoExpandableItem item1 = new DemoExpandableItem(0, "DCS1");
        ArrayList<ExpandableSubItem> item1Sub = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            if (i != 5) {
                if (i == 0) {
                    item1Sub.add(new DemoExpandableSubItemImage(i, "image " + i));
                } else {
                    item1Sub.add(new DemoExpandableSubItemText(i, "text " + i));
                }
            } else {
                item1Sub.add(new DemoExpandableSubItemImage(i, "image " + i));
            }
        }
        item1.addSubItems(item1Sub, true);
        mData.add(item1);
        DemoExpandableItem item2 = new DemoExpandableItem(0, "DCS2");
        mData.add(item2);
        DemoExpandableItem item3 = new DemoExpandableItem(0, "DCS3");
        mData.add(item3);
        ArrayList<ExpandableSubItem> item3Sub = new ArrayList<>();
        item3Sub.add(new DemoExpandableSubItemImage(0, "image " + 0));
        item3.addSubItems(item3Sub, true);
        DemoExpandableItem item4 = new DemoExpandableItem(0, "DCS4");
        mData.add(item4);
        DemoExpandableItem item5 = new DemoExpandableItem(0, "DCS5");
        mData.add(item5);
        ArrayList<ExpandableSubItem> item5Sub = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            if (i != 5) {
                item5Sub.add(new DemoExpandableSubItemText(i, "text " + i));
            } else {
                item5Sub.add(new DemoExpandableSubItemImage(i, "image " + i));
            }
        }
        item5.addSubItems(item5Sub, true);

        for (int i = 0; i < 200; ++i) {
            DemoExpandableItem itemH = new DemoExpandableItem(0, "DCS" + (i + 6));
            mData.add(itemH);
        }

        notifyDataSetChanged();
    }
}
